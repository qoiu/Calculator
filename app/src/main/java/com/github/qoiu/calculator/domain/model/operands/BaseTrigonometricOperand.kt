package com.github.qoiu.calculator.domain.model.operands

import com.github.qoiu.calculator.domain.model.Calculator

abstract class BaseTrigonometricOperand(value: String): BaseOperand<Double>(value) {

    fun init(operand: BaseOperand<*>): BaseTrigonometricOperand{
        return OperandSin(operand.value().toString())
    }

    override fun result(): Calculator.Operand  =
        OperandDouble(operation(Math.toRadians(value())).toString()).fixValue()

    override fun append(symbol: String): BaseOperand<*> {
        this.value = "$value$symbol"
        return this
    }

    override fun value(): Double = value.toDouble()

    abstract fun operation(double: Double) : Double

    override fun toString(): String {
        return "sin($value)"
    }
}