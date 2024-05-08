package com.example.littlelemon.ui.common


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.littlelemon.database.entities.MenuItem
import com.example.littlelemon.ui.theme.LittleLemonGreen
import java.text.DecimalFormat


@Composable
fun MenuItemComposable(menuItem: MenuItem) {
    val decimalFormat = DecimalFormat("#,###.00")
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp)
        .padding(top = 16.dp)){
        Text(text = menuItem.title, style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp))
        Row (modifier = Modifier
            .padding(bottom = 16.dp)
            .height(IntrinsicSize.Min), horizontalArrangement = Arrangement.spacedBy(20.dp)){
            Column (modifier = Modifier
                .weight(.4f)
                .fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween){
                Text(text = menuItem.description,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis)

                Text(text = "$ ${decimalFormat.format(menuItem.price)}",
                    style = MaterialTheme.typography.titleMedium,
                    color = LittleLemonGreen
                    )


            }
            SubcomposeAsyncImage(model = menuItem.image, contentDescription = "${menuItem.title} Image",
                loading = { CircularProgressIndicator(modifier = Modifier.width(100.dp).height(100.dp))},
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .weight(.2f)
                    .width(100.dp)
                    .height(100.dp)
               )
        }
        Divider()
    }
}

@Composable
@Preview(showBackground = true)
fun MenuItemComposablePreview() {
    val testItem = MenuItem(1,"Greek Salad",
        "The famous greek salad of crispy lettuce, peppers, olives, our Chicago.",
        10.0,
        "https://github.com/Meta-Mobile-Developer-PC/Working-With-Data-API/blob/main/images/greekSalad.jpg?raw=true",
        "starters")

    MenuItemComposable(testItem)
}