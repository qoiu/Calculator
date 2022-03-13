package com.github.qoiu.calculator.domain.model.operands

import com.github.qoiu.calculator.domain.model.Calculator

sealed class Operand<T : Number>(
    protected var value: String,
    private val lengthMax: Int
) : Calculator, OperandMethods {
    abstract fun value(): T

    override fun result(): Operand<*> = classCheck().fixValue()

    override fun append(symbol: String): Operand<*> {
        this.value = "$value$symbol"
        return classCheck()
    }

    override fun delete(): Operand<*> {
        if (value.isNotEmpty()) {
            this.value = value.substring(0, value.length - 1)
        }
        return classCheck()
    }

    fun classCheck(): Operand<*> {
        if (value.isBlank())
            return OperandEmpty()
        return if (value.length > 15) {
            toOperandDecimal()
        } else if (value.contains('.')) {
            toOperandDouble()
        } else {
            toOperandLong()
        }
    }

    /**
     * if value is incorrect for this type, this method try to return Operand of correct type
     */
    override fun fixValue(): Operand<*> {
        return this
    }

    override fun toOperandLong() = if (this is OperandLong) this else OperandLong(value)
    override fun toOperandDouble() = if (this is OperandDouble) this else OperandDouble(value)
    override fun toOperandDecimal() = if (this is OperandDecimal) this else OperandDecimal(value)

    override fun toString(): String = value

    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (javaClass != other?.javaClass)
            return false
        other as Operand<*>
        if (value != other.value)
            return false
        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}