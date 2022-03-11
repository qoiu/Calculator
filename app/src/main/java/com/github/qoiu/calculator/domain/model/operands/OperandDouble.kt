package com.github.qoiu.calculator.domain.model.operands

class OperandDouble(value: String) :
    Operand<Double>(value, 2, 9) {

    override fun fixValue(): Operand<*> =
        try {
            val doubleValue = value.toDouble()
            val longValue = doubleValue.toLong()
            if (doubleValue.equals(longValue.toDouble())) {
                this.value = longValue.toString()
            }
            classCheck()
        } catch (e: Exception) {
            println(e.toString())
            classCheck()
        }

    override fun value(): Double = value.toDouble()
}