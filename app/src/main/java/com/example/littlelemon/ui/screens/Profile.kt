package com.example.littlelemon.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.R
import com.example.littlelemon.navigation.Screen
import com.example.littlelemon.ui.common.DefaultButton
import com.example.littlelemon.ui.common.LittleLemonHeader
import com.example.littlelemon.util.PreferenceManager

@Composable
fun Profile(navController: NavHostController) {
    val preferenceManager = PreferenceManager(LocalContext.current)
    var firstName by remember { mutableStateOf(preferenceManager.getString("firstName",""))}
    var lastName by remember { mutableStateOf(preferenceManager.getString("lastName","")) }
    var email by remember { mutableStateOf(preferenceManager.getString("email","")) }


    Column {
        Row(modifier = Modifier.weight(.2f)) {
            LittleLemonHeader()
        }

        Column(
            modifier = Modifier
                .weight(.5f)
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.personal_information),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 32.dp)
            )
            OutlinedTextField(
                value = firstName,
                enabled = false,
                onValueChange = { firstName = it },
                label = { Text(text = stringResource(R.string.firstname)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
            OutlinedTextField(
                value = lastName,
                onValueChange = { lastName = it },
                enabled = false,
                label = { Text(text = stringResource(R.string.lastname)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                enabled = false,
                label = { Text(text = stringResource(R.string.email)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

        }

        DefaultButton(text = "Log out") {
            preferenceManager.clear()
            navController.navigate(Screen.ONBOARDING.name)
        }


    }

}

@Composable
@Preview(showBackground = true)
fun ProfilePreview() {
    Profile(navController = rememberNavController())
}