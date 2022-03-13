package com.github.qoiu.calculator.domain.model.operands

class OperandLong(value: String) :
    BaseOperand<Long>(value) {

    override fun value(): Long = this.value.toLong()
}