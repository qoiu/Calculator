package com.github.qoiu.calculator.domain.model.operands

class OperandEmpty : BaseOperand<Number>("") {
    private val emptyException = IllegalStateException("Empty don't have any result or value")
    override fun result(): BaseOperand<*> {
        throw emptyException
    }

    override fun value(): Number {
        throw emptyException
    }

    override fun toString(): String = ""
}