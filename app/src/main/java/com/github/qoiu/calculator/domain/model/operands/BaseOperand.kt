package com.github.qoiu.calculator.domain.model.operands

import com.github.qoiu.calculator.domain.model.BaseCalculatorObject
import com.github.qoiu.calculator.domain.model.CalculatorObject
import com.github.qoiu.calculator.domain.model.CalculatorObject.Operand
import com.github.qoiu.calculator.domain.model.operators.OperatorAdd

sealed class BaseOperand<T : Number>(
    protected var value: String
) : BaseCalculatorObject(), Operand {
    abstract fun value(): T

    override fun result(): Operand = fixValue()

    override fun append(operand: Operand): CalculatorObject {
        return OperatorAdd(this, operand)
    }

    override fun append(symbol: String): Operand {
        if (value.length > 15) throw IllegalStateException("Number is too big")
        this.value = "$value$symbol"
        return fixValue()
    }

    override fun lastOperand(): Operand = this

    override fun append(operator: CalculatorObject.Operator): CalculatorObject = operator.init(this)

    override fun append(operator: CalculatorObject.Trigonometric): CalculatorObject =
        operator.init(this)

    override fun delete(): Operand {
        return if (value.isNotEmpty()) {
            this.value = value.substring(0, value.length - 1)
            this
        }else {
            OperandEmpty()
        }
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

    override fun toString(): String = if (value[0] == '-') "($value)" else value

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