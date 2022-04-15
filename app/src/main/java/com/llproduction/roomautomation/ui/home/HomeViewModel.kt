package com.llproduction.roomautomation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class HomeViewModel: ViewModel() {

    private var _tvButtonPress: MutableStateFlow<String> =
        MutableStateFlow("Hello World")
    val tvButtonPress: StateFlow<String> get() = _tvButtonPress


    fun updateTextView() {
        viewModelScope.launch {
            _tvButtonPress.emit("Pressed")
        }
    }

}