package com.github.qoiu.calculator.domain.model

import com.github.qoiu.calculator.domain.model.operands.Operand

interface Calculator {
    fun result(): Operand<*>
    fun append(symbol: String): Calculator
    fun delete(): Calculator
}