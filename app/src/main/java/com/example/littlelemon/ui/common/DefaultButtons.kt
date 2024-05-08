package com.example.littlelemon.ui.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemon.ui.theme.LittleLemonGreen
import com.example.littlelemon.ui.theme.LittleLemonLightGray
import com.example.littlelemon.ui.theme.LittleLemonSalmon
import com.example.littlelemon.ui.theme.LittleLemonYellow
import com.example.littlelemon.util.Categories

@Composable
fun DefaultButton(text: String, onclick: () -> Unit) {
    Button(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(), shape = RoundedCornerShape(16),
        border = BorderStroke(1.dp, color = LittleLemonSalmon),
        colors = ButtonDefaults.buttonColors(LittleLemonYellow),
        onClick = onclick
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black
        )

    }
}

@Composable
fun MaterialButtonToggleGroup(
    items: List<String>,
    onClick: (index: Int) -> Unit = {}
) {
    val (selectedIndex, onIndexSelected) = remember { mutableStateOf<Int?>(null) }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 16.dp)
    ) {
        items.forEachIndexed { index, item ->
            Button(
                onClick = {
                    if(index == selectedIndex) {
                        onIndexSelected(null)
                    } else {
                        onIndexSelected(index)
                    }
                    onClick(index)

                },
                shape = RoundedCornerShape(16),
                contentPadding = PaddingValues(
                    horizontal = 16.dp
                ),
                colors = if (selectedIndex == index) {
                    // selected colors
                    ButtonDefaults.buttonColors(
                        containerColor = LittleLemonSalmon,
                        contentColor = LittleLemonSalmon
                    )
                } else {
                    // not selected colors
                    ButtonDefaults.buttonColors(
                        containerColor = LittleLemonLightGray,
                        contentColor = LittleLemonLightGray
                    )
                }
            ) {
                Text(
                    text = item,
                    color = if (selectedIndex == index) {
                        LittleLemonGreen
                    } else {
                       LittleLemonGreen
                    },
                    style = MaterialTheme.typography.titleSmall,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MaterialButtonToggleGroupPreview(){
    val selectionOptions = Categories.entries.map { it.categoryName }.toList()
    MaterialButtonToggleGroup(items = selectionOptions)
}




