package com.github.qoiu.calculator

import com.github.qoiu.calculator.data.CalculatorMemory
import com.github.qoiu.calculator.domain.CalculatorInteractor
import com.github.qoiu.calculator.domain.UseCaseAppend
import com.github.qoiu.calculator.domain.UseCaseObserveOutput

class Core {
    lateinit var useCaseAppend: UseCaseAppend
    lateinit var useCaseObserver: UseCaseObserveOutput
    lateinit var calculatorMemory: CalculatorMemory

    fun init() {
        calculatorMemory = CalculatorMemory.Base()
        val interactor = CalculatorInteractor(calculatorMemory)
        useCaseAppend = interactor
        useCaseObserver = interactor
    }
}