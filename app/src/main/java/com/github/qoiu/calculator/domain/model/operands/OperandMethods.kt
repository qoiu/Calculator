package com.github.qoiu.calculator.domain.model.operands

import java.math.BigDecimal

interface OperandMethods {
    fun toOperandLong(): OperandLong
    fun toOperandDouble(): OperandDouble
    fun toOperandDecimal(): OperandDecimal
    fun compareTypeWith(operand: Operand<*>): Operand<*>
    fun fixValue(): Operand<*>
}

class OperandLong(value: String) :
    Operand<Long>(value, 1, 9) {

    override fun value(): Long = this.value.toLong()
}

class OperandDouble(value: String) :
    Operand<Double>(value, 2, 9) {

    override fun fixValue(): Operand<*> {
        if (value.contains('E'))
            return OperandDecimal(value.toDouble().toBigDecimal().toString())
        return simplify()
    }

    private fun simplify(): Operand<*> =
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

class OperandDecimal(value: String) :
    Operand<BigDecimal>(value, 3, 20) {
    override fun value(): BigDecimal = value.toBigDecimal()


}

class OperandEmpty : Operand<Number>("", 0, 20) {
    private val emptyException = IllegalStateException("Empty don't have any result or value")
    override fun result(): Operand<*> {
        throw emptyException
    }

    override fun value(): Number {
        throw emptyException
    }
}