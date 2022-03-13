package com.github.qoiu.calculator.domain.model.operands

import com.github.qoiu.calculator.domain.model.Calculator
import com.github.qoiu.calculator.domain.model.Calculator.Operand

sealed class BaseOperand<T : Number>(
    protected var value: String
) : Operand {
    abstract fun value(): T

    override fun result(): Operand = fixValue()

    override fun append(symbol: String): Operand {
        this.value = "$value$symbol"
        return fixValue()
    }

    override fun append(operator: Calculator.Operator) = operator.init(this)

    override fun delete(): Operand {
        if (value.isNotEmpty()) {
            this.value = value.substring(0, value.length - 1)
        }
        return this
    }

    override fun fixValue(): Operand {
        return when {
            value.isBlank() -> OperandEmpty()
            value.length > 15 -> toOperandDecimal()
            value.contains('.') -> toOperandDouble()
            else -> toOperandLong()
        }
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
        other as BaseOperand<*>
        if (value != other.value)
            return false
        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}