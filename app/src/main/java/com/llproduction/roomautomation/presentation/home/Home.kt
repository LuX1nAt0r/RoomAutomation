package com.llproduction.roomautomation.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

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


@Preview
@Composable
fun Home(
    viewModel: HomeViewModel = HomeViewModel()
) {

    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        BlindsButtons(blind = Blind(
            name = "Rollo Links",
            blindState = viewModel.blindLeftState.collectAsState().value
            ), viewModel = viewModel
        )

        BlindsButtons(
            blind = Blind(
                name = "Rollo Rechts",
                blindState = viewModel.blindRightState.collectAsState().value
            ),
            viewModel = viewModel
        )




    }


}

@Composable
fun BlindsButtons(blind: Blind, viewModel: HomeViewModel, space: Dp = 24.dp) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(all = 8.dp)
    ) {

        Text(text = blind.name)
        Spacer(modifier = Modifier.height(space))
        Text(text = blind.blindState.toString())
        Spacer(modifier = Modifier.height(space))

        
        Button(onClick = {
            viewModel.updateBlind(Blind(blind.name, 0.0f))
        }) {
            Text(text = "Open")
        }

        Spacer(modifier = Modifier.height(space))

        Button(onClick = {
            viewModel.updateBlind(Blind(blind.name, 0.5f))
        }) {
            Text(text = "Half Open")
        }
        
        Spacer(modifier = Modifier.height(space))
        
        Button(onClick = {
            viewModel.updateBlind(Blind(blind.name, 1.0f))
        }) {
            Text(text = "Close" )
        }

    }
}

