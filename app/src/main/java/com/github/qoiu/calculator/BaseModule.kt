package com.github.qoiu.calculator

import androidx.lifecycle.ViewModel
import com.github.qoiu.calculator.presentation.keyboard.KeyboardViewModel
import com.github.qoiu.calculator.presentation.output.OutputViewModel

interface BaseModule<T : ViewModel> {
    fun viewModel(): T

    class Keyboard(private val core: Core) : BaseModule<KeyboardViewModel> {
        override fun viewModel() = KeyboardViewModel(core.useCaseAppend)
    }

    class Output(private val core: Core) : BaseModule<OutputViewModel> {
        override fun viewModel() = OutputViewModel(core.useCaseObserver)
    }


}
