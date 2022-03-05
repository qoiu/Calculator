package com.github.qoiu.calculator.presentation

sealed class UiKey(val value: String){
    abstract fun action()

    class Number(private val actions: KeyboardActions, key: String): UiKey(key){
        override fun action(){
            actions.appendNumber(value)
        }
    }
}
