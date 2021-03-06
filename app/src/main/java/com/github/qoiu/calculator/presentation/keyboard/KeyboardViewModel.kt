package com.github.qoiu.calculator.presentation.keyboard

import androidx.lifecycle.ViewModel
import com.github.qoiu.calculator.domain.UseCaseAppend

class KeyboardViewModel(private val cases: UseCaseAppend) : ViewModel(), KeyboardActions {
    override fun appendNumber(value: String) {
        cases.appendNumber(value)
    }

    override fun appendOperator(value: String) {
        cases.appendOperator(value)
    }
}