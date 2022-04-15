package com.llproduction.roomautomation.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import kotlin.reflect.KSuspendFunction0

@Preview
@Composable
fun Home(
    viewModel: HomeViewModel = HomeViewModel()
){
    val tvButtonPress = viewModel.tvButtonPress.collectAsState()
    
    Home(
        buttonPress = tvButtonPress,
        onButtonClick = viewModel::updateTextView
    )
}



@Composable
fun Home(
    buttonPress: State<String>,
    onButtonClick: () -> Unit
) {

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = buttonPress.value)

        Button(


            onButtonClick
        ) {
            Text(text = "Press")

        }

        var sliderPosition by remember { mutableStateOf(0f)}

        Slider(
            value = sliderPosition,
            onValueChange = {sliderPosition = it},
            onValueChangeFinished = {}
        )


    }


}

