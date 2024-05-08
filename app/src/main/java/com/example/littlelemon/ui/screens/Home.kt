package com.example.littlelemon.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.R
import com.example.littlelemon.database.LittleLemonDatabase
import com.example.littlelemon.database.entities.MenuItem
import com.example.littlelemon.ui.common.LittleLemonProfileHeader
import com.example.littlelemon.ui.common.MaterialButtonToggleGroup
import com.example.littlelemon.ui.common.MenuItemComposable
import com.example.littlelemon.ui.theme.LittleLemonGreen
import com.example.littlelemon.ui.theme.LittleLemonLightGray
import com.example.littlelemon.ui.theme.LittleLemonTheme
import com.example.littlelemon.ui.theme.LittleLemonYellow
import com.example.littlelemon.util.Categories
import java.util.Locale


@Composable
fun Home(navController: NavHostController) {

    val database = LittleLemonDatabase.getInstance(LocalContext.current)
    val menuItems by database.menuItemDao().getAll().observeAsState(emptyList())

    val selectionOptions = Categories.entries.map { it.categoryName }.toList()
    var selectedCategory by remember {
        mutableStateOf("")
    }

    var searchPhrase by remember {
        mutableStateOf("")
    }

    Column {
        LittleLemonProfileHeader(navController = navController)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = LittleLemonGreen)
                .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
        ) {

            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.displayLarge,
                color = LittleLemonYellow,
                modifier = Modifier.height(54.dp)
            )
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.weight(.5f)) {
                    Text(
                        text = stringResource(id = R.string.location),
                        style = MaterialTheme.typography.headlineLarge,
                        color = Color.White,
                    )
                    Text(
                        text = stringResource(id = R.string.slogan),
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.hero_image),
                    contentDescription = "Hero Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .width(120.dp)
                        .height(150.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
            }
            TextField(
                value = searchPhrase, onValueChange = {
                    searchPhrase = it
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = stringResource(R.string.search_icon)
                    )
                },
                placeholder = { Text(stringResource(R.string.enter_search_phrase)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)

            )


        }

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = stringResource(id = R.string.order_delivery).uppercase(Locale.ROOT),
                style = MaterialTheme.typography.titleLarge
            )
            MaterialButtonToggleGroup(items = selectionOptions) {
                selectedCategory =
                    if (selectionOptions[it].equals(selectedCategory, ignoreCase = true)) {
                        ""
                    } else {
                        selectionOptions[it]
                    }
            }

            Divider(
                modifier = Modifier.border(
                    width = 5.dp,
                    shape = RectangleShape,
                    color = LittleLemonLightGray
                )
            )

            MenuItemsList(menuItems = menuItems, selectedCategory = selectedCategory, searchPhrase)

        }

    }
}


@Composable
private fun MenuItemsList(menuItems: List<MenuItem>, selectedCategory:String, searchPhrase:String) {
    LazyColumn {
        items(
            items = if (selectedCategory.isBlank() && searchPhrase.isBlank()) {
                menuItems
            } else if(searchPhrase.isNotBlank()){
                menuItems.filter { it.title.contains(searchPhrase, ignoreCase = true) }
            } else {
                   menuItems.filter { it.category.equals(selectedCategory, ignoreCase = true) }
                   },
            itemContent = { item: MenuItem -> MenuItemComposable(menuItem = item) }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun HomePreview() {
    LittleLemonTheme {
        Home(navController = rememberNavController())
    }

}