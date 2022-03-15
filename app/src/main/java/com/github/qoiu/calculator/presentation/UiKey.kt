package com.github.qoiu.calculator.presentation

import com.github.qoiu.calculator.presentation.keyboard.KeyboardActions

sealed class UiKey(protected val key: String) {
    abstract fun action()
    open fun getText(): String = key

    class Number(private val actions: KeyboardActions, key: String) : UiKey(key) {
        override fun action() {
            actions.appendNumber(key)
        }
    }

    class Operator(private val actions: KeyboardActions, key: String) : UiKey(key) {
        override fun action() {
            actions.appendOperator(key)
        }
    }

    class Switcher(
        private val actions: KeyboardActions,
        private val key1: String,
        private val key2: String
    ) : UiKey(key1) {
        private var first = true
        override fun action() {
            first = !first
            actions.appendOperator(if (first) key1 else key2)
        }

        override fun getText(): String = if (first) key1 else key2
    }
}