package com.llproduction.roomautomation.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.llproduction.roomautomation.ui.theme.RoomAutomationTheme

@Composable
fun Home(
    onButtonClick: () -> Unit?,

) {
    var testText by remember {
        mutableStateOf("Test")
    }

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = testText)

        Button(


            onClick = { testText = "Pressed"},
        ) {
            Text(text = "Press")

        }
    }


}

