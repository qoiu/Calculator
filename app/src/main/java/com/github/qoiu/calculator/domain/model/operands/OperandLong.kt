package com.github.qoiu.calculator.domain.model.operands

class OperandLong(value: String) :
    Operand<Long>(value, 9) {

    override fun value(): Long = this.value.toLong()
}