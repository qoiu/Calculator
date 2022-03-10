package com.github.qoiu.calculator.domain.model

import java.math.BigDecimal

class OperandLong(value: String) :
    Calculator.Operand<Long>(value, 1, 9) {
    override fun plus(operand: Operand<Long>): Operand<*> {
        this.value = operand.toLong().value.toLong().plus(value.toLong()).toString()
        return classCheck()
    }

    override fun minus(operand: Operand<Long>): Operand<*> {
        this.value = operand.toLong().value.toLong().minus(value.toLong()).toString()
        return classCheck()
    }
}

class OperandDouble(value: String) :
    Calculator.Operand<Double>(value, 2, 9) {
    override fun plus(operand: Operand<Double>): Operand<*> {
        val result = operand.toDouble().value.toDouble().plus(value.toDouble()).toString()
        this.value = if (result.contains('E')) {
            operand.toDecimal().plus(OperandDecimal(value)).toString()
        } else {
            result
        }
        return simplify()
    }

    override fun minus(operand: Operand<Double>): Operand<*> {
        val result = operand.toDouble().value.toDouble().minus(value.toDouble()).toString()
        this.value = if (result.contains('E')) {
            operand.toDecimal().minus(OperandDecimal(value)).toString()
        } else {
            result
        }
        return simplify()
    }
}

class OperandDecimal(value: String, scale: Int = 0) :
    Calculator.Operand<BigDecimal>(value, 3, 20) {

    override fun plus(operand: Operand<BigDecimal>): Operand<*> {
        this.value = operand.toDecimal().value.toBigDecimal().plus(value.toBigDecimal()).toString()
        return simplify()
    }

    override fun minus(operand: Operand<BigDecimal>): Operand<*> {
        this.value = operand.toDecimal().value.toBigDecimal().minus(value.toBigDecimal()).toString()
        return simplify()
    }
}

class OperandEmpty : Calculator.Operand<Number>("", 0, 20) {
    private val emptyException = IllegalStateException("Empty don't have any result")
    override fun result(): Operand<*> {
        throw emptyException
    }

    override fun plus(operand: Operand<Number>): Operand<*> {
        throw emptyException
    }

    override fun minus(operand: Operand<Number>): Operand<*> {
        throw emptyException
    }
}