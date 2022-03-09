package com.github.qoiu.calculator.presentation

import com.github.qoiu.calculator.presentation.keyboard.KeyboardActions

sealed class UiKey(val value: String) {
    abstract fun action()

    class Number(private val actions: KeyboardActions, key: String) : UiKey(key) {
        override fun action() {
            actions.appendNumber(value)
        }
    }
}