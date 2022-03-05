package com.github.qoiu.calculator.domain

sealed class Calculator {
    data class Operand(private var value: Number, private var isDouble: Boolean = false): Calculator(){

        fun action(append: Number) {
            if (isDouble){
                value = "${value}$append".toDouble()
            }else{
                value = "${value}$append".toLong()
            }
        }
    }
    class Add(): Calculator()
}