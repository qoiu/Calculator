package com.github.qoiu.calculator.domain.model.operands

import com.github.qoiu.calculator.domain.model.CalculatorObject

class ConstantE : BaseOperand<Double>(Math.E.toString()) {
    override fun append(symbol: String): CalculatorObject.Operand = this
    override fun mod() {}

    override fun toString(): String = "e"

    override fun value(): Double = Math.E
}