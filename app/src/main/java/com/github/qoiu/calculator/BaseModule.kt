package com.github.qoiu.calculator

import androidx.lifecycle.ViewModel
import com.github.qoiu.calculator.presentation.KeyboardViewModel

interface BaseModule<T: ViewModel> {
    fun viewModel(): T

    class Keyboard(private val core: Core):BaseModule<KeyboardViewModel>{
        override fun viewModel() = KeyboardViewModel(core.useCaseAppend)
    }
}
