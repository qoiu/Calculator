package com.github.qoiu.calculator.domain.model.operands

class OperandEmpty : Operand<Number>("", 20) {
    private val emptyException = IllegalStateException("Empty don't have any result or value")
    override fun result(): Operand<*> {
        throw emptyException
    }

    override fun value(): Number {
        throw emptyException
    }

    override fun toString(): String = ""
}