package com.github.qoiu.calculator.domain.model.operands

import com.github.qoiu.calculator.domain.model.CalculatorObject

class ConstantPi : BaseOperand<Double>(Math.PI.toString()) {
    override fun append(symbol: String): CalculatorObject.Operand = this
    override fun mod() {}

    override fun toString(): String = "π"

    override fun value(): Double = Math.PI
}