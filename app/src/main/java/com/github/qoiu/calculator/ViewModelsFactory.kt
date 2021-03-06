package com.github.qoiu.calculator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.qoiu.calculator.presentation.keyboard.KeyboardViewModel
import com.github.qoiu.calculator.presentation.output.OutputViewModel

class ViewModelsFactory(private val core: Core) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when (modelClass) {
            KeyboardViewModel::class.java -> BaseModule.Keyboard(core).viewModel() as T
            OutputViewModel::class.java -> BaseModule.Output(core).viewModel() as T
            else -> throw IllegalStateException("unknown viewModel $modelClass")
        }
}