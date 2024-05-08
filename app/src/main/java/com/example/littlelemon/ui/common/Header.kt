package com.example.littlelemon.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.R
import com.example.littlelemon.navigation.NavigationItem

@Composable
fun LittleLemonHeader() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo of Little Lemon Restaurant",
            modifier = Modifier
                .scale(3f)
        )
    }
}

@Composable
fun LittleLemonProfileHeader(navController: NavController) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = stringResource(R.string.logo_of_little_lemon_restaurant),
            modifier = Modifier
                .scale(3f)
                .weight(.85f)
        )

        Box(modifier = Modifier.clickable {
            navController.navigate(NavigationItem.Profile.route)
        }) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = stringResource(R.string.profile),
                modifier = Modifier
                    .height(50.dp)
                    .padding(horizontal = 16.dp),
            )
        }

    }


}

@Preview(showBackground = true)
@Composable
fun LittleLemonHeaderPreview() {
    LittleLemonProfileHeader(navController = rememberNavController())
}