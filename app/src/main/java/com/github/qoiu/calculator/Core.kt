package com.github.qoiu.calculator

import com.github.qoiu.calculator.data.CalculatorMemory
import com.github.qoiu.calculator.domain.UseCaseAppend

class Core {
    lateinit var useCaseAppend: UseCaseAppend
    lateinit var calculatorMemory: CalculatorMemory

    fun init(){
        calculatorMemory = CalculatorMemory.Base()
        useCaseAppend = UseCaseAppend.Base(calculatorMemory)
    }
}