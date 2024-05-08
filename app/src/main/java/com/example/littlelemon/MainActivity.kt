package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.database.LittleLemonDatabase
import com.example.littlelemon.database.entities.MenuItem
import com.example.littlelemon.navigation.LittleLemonNavHost
import com.example.littlelemon.navigation.Screen
import com.example.littlelemon.network.MenuItemNetwork
import com.example.littlelemon.network.MenuNetwork
import com.example.littlelemon.ui.theme.LittleLemonTheme
import com.example.littlelemon.util.PreferenceManager
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

const val TAG = "LittleLemonMain"
const val LITTLE_LEMON_URL =
    "https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json"

class MainActivity : ComponentActivity() {

    private val httpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json(
                contentType = ContentType("text", "plain")
            )
        }
    }

    private val database by lazy { LittleLemonDatabase.getInstance(this) }
    private val preferenceManager by lazy { PreferenceManager(this) }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val destination: String = if (isSignedIn()) {
                Screen.HOME.name
            } else {
                Screen.ONBOARDING.name
            }

        lifecycleScope.launch(IO) {
            if(database.menuItemDao().isEmpty()) {
                val menuItemsNetwork = fetchMenu();
                addToDatabase(menuItemsNetwork)
            }
        }

        enableEdgeToEdge()
        setContent {
            LittleLemonTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LittleLemonNavHost(
                        modifier = Modifier.padding(innerPadding),
                        navHostController = rememberNavController(),
                        startDestination = destination,
                    )
                }
            }
        }
    }

    private suspend fun fetchMenu(): List<MenuItemNetwork> {
        val response = httpClient.get(LITTLE_LEMON_URL)
            .body<MenuNetwork>()
        return response.menu
    }

    private fun addToDatabase(menuItemsNetwork: List<MenuItemNetwork>) {
        val menuItems: List<MenuItem> = menuItemsNetwork.map { it.toMenuItem() };
        database.menuItemDao().insert(*menuItems.toTypedArray())


    }

    private fun isSignedIn():Boolean {
        val firstName = preferenceManager.getString("firstName", "")
        val lastName = preferenceManager.getString("lastName", "")
        val email = preferenceManager.getString("email", "")

        return firstName.isNotBlank() && lastName.isNotBlank() && email.isNotBlank()
    }
}

