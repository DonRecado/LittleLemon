package com.example.littlelemon.ui.screens

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.R
import com.example.littlelemon.navigation.Screen
import com.example.littlelemon.ui.common.DefaultButton
import com.example.littlelemon.ui.common.LittleLemonHeader
import com.example.littlelemon.ui.theme.LittleLemonGreen
import com.example.littlelemon.util.PreferenceManager


@Composable
fun Onboarding(navController: NavController) {
    val preferenceManager = PreferenceManager(LocalContext.current)

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column {
        LittleLemonHeader()
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(LittleLemonGreen)
                .weight(3 / 10f)
                .padding(vertical = 16.dp, horizontal = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.onboard_slogan),
                style = MaterialTheme.typography.displayMedium,
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }

        Column(
            modifier = Modifier
                .padding(16.dp)
                .weight(5 / 10f)
        ) {
            Text(
                text = stringResource(R.string.personal_information),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 32.dp)
            )
            OutlinedTextField(
                value = firstName,
                onValueChange = { firstName = it },
                label = { Text(stringResource(R.string.firstname)) },
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth()
            )
            OutlinedTextField(
                value = lastName,
                onValueChange = { lastName = it },
                label = { Text(text = stringResource(R.string.lastname)) },
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth()
            )
            OutlinedTextField(
                value = email,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                onValueChange = { email = it },
                label = { Text(text = stringResource(R.string.email)) },
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth()
            )
        }

        Row(modifier = Modifier.weight(1 / 10f)) {
            DefaultButton(text = stringResource(R.string.register)) {
                if (firstName.isBlank() || lastName.isBlank() || email.isBlank()) {
                    Toast.makeText(
                        context,
                        context.getString(R.string.registration_unsuccessful),
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    preferenceManager.saveString(Pair("firstName", firstName))
                    preferenceManager.saveString(Pair("lastName", lastName))
                    preferenceManager.saveString(Pair("email", email))

                    Toast.makeText(context,
                        context.getString(R.string.registration_successful), Toast.LENGTH_SHORT).show()
                    navController.navigate(Screen.HOME.name);
                }
            }
        }
    }

}


@Composable
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
fun OnboardingPreview() {
    Onboarding(rememberNavController())


}