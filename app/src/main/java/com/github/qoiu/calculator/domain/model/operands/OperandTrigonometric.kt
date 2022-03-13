package com.github.qoiu.calculator.domain.model.operands

abstract class OperandTrigonometric(value: String): Operand<Double>(value,9) {

    fun init(operand: Operand<*>): OperandTrigonometric{
        return OperandSin(operand.value().toString())
    }

    override fun result(): Operand<*> =
        OperandDouble(operation(Math.toRadians(value())).toString()).fixValue()

    override fun append(symbol: String): Operand<*> {
        this.value = "$value$symbol"
        return this
    }

    override fun value(): Double = value.toDouble()

    abstract fun operation(double: Double) : Double

    override fun toString(): String {
        return "sin($value)"
    }
}