package com.llproduction.roomautomation.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class HomeViewModel: ViewModel() {

    private var _tvButtonPress: MutableStateFlow<String> =
        MutableStateFlow("Unpressed")
    val tvButtonPress: StateFlow<String> get() = _tvButtonPress

    private var _blindLeftState: MutableStateFlow<Float> =
        MutableStateFlow(0.5f)
    val blindLeftState: StateFlow<Float> get() = _blindLeftState

    private var _blindRightState: MutableStateFlow<Float> =
        MutableStateFlow(0.5f)
    val blindRightState: StateFlow<Float> get() = _blindRightState




    fun updateTextView() {
        viewModelScope.launch {


            when (_tvButtonPress.value){
                "Pressed" -> _tvButtonPress.emit("Unpressed")
                "Unpressed" -> _tvButtonPress.emit("Pressed")
            }


        }
    }


    fun updateBlind(blind: Blind) {
        viewModelScope.launch {
            when (blind.name){
                "Rollo Links" -> {
                    _blindLeftState.emit(blind.blindState)
                }
                "Rollo Rechts" -> {
                    _blindRightState.emit(blind.blindState)
                }
            }


        // _blindLeftState.emit(blind.blindState)
            //Log.i("Blind", blindLeftState.value.toString())
        }
    }

}