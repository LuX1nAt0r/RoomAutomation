package com.llproduction.roomautomation.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import kotlin.reflect.KSuspendFunction0


@Composable
fun Home(
    viewModel: HomeViewModel = HomeViewModel()
){
    val tvButtonPress = viewModel.tvButtonPress.collectAsState()
    
    Home(
        buttonPress = tvButtonPress,
        onClick = viewModel::updateTextView
    )
}



@Composable
fun Home(
    buttonPress: State<String>,
    onClick: () -> Unit
) {
    var testText by remember {
        mutableStateOf("Test")
    }


    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = buttonPress.value)

        Button(


            onClick = { onClick},
        ) {
            Text(text = "Press")

        }
    }


}

