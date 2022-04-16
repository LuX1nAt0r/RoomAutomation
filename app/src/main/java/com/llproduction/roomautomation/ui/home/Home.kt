package com.llproduction.roomautomation.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import kotlin.reflect.KSuspendFunction0

/*@Preview
@Composable
fun Home(
    viewModel: HomeViewModel = HomeViewModel()
){
    val tvButtonPress = viewModel.tvButtonPress.collectAsState()
    
    Home(
        buttonPress = tvButtonPress,
        onButtonClick = viewModel::updateTextView
    )
}*/



@Composable
fun Home(
    viewModel: HomeViewModel = HomeViewModel()
) {

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        BlindsButtons(blind = Blind(
            name = "Rollo Links",
            blindState = viewModel.blindLeftState.value
            ), viewModel = viewModel
        )




    }


}

@Composable
fun BlindsButtons(blind: Blind, viewModel: HomeViewModel) {
    Column() {
        Button(onClick = {
            viewModel.updateBlind(blind.apply { blind.blindState = 0.0f })
        }) {
            Text(text = "${blind.name} Open")
        }
        Button(onClick = { blind.blindState = 0.5f }) {
            Text(text = "${blind.name} Half Open")
        }
        Button(onClick = { blind.blindState = 1.0f }) {
            Text(text = "${blind.name} Close" )
        }

    }
}

