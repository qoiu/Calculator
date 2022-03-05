package com.github.qoiu.calculator.domain

import com.github.qoiu.calculator.data.CalculatorMemory
import java.lang.Exception

interface UseCaseAppend{
    fun append(value: String)
    class Base(private val memory: CalculatorMemory): UseCaseAppend {
        override fun append(value: String) {
            try {
                memory.append(value.toInt())
            }catch (e: Exception){

            }
        }
    }
}