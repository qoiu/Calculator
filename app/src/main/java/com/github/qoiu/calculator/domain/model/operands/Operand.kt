package com.github.qoiu.calculator.domain.model.operands

import com.github.qoiu.calculator.domain.model.Calculator

sealed class Operand<T : Number>(
    protected var value: String,
    private val weight: Int,
    private val lengthMax: Int
) : Calculator, OperandMethods {
    abstract fun value(): T

    override fun result(): Operand<*> = this

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

    protected fun classCheck(): Operand<*> {
        if (value.isBlank())
            return OperandEmpty()
        return if (value.contains('.')) {
            if (value.length > 9) {
                toOperandDecimal()
            } else {
                toOperandDouble()
            }
        } else {
            if (value.length > lengthMax)
                throw IllegalStateException("You can use only $lengthMax symbols")
            toOperandLong()
        }
    }

    /**
     * if value is incorrect for this type, this method try to return Operand of correct type
     */
    override fun fixValue(): Operand<*> {
        return this
    }

    override fun compareTypeWith(operand: Operand<*>): Operand<*> =
        when (operand.weight.coerceAtLeast(this.weight)) {
            1 -> toOperandLong()
            2 -> toOperandDouble()
            3 -> toOperandDecimal()
            else -> {
                throw java.lang.ClassCastException("Error in Operand type compare: Unknown class")
            }
        }

    override fun toOperandLong() = OperandLong(value)
    override fun toOperandDouble() = OperandDouble(value)
    override fun toOperandDecimal() = OperandDecimal(value)

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