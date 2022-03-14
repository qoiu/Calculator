package com.github.qoiu.calculator.domain.model.operands

import com.github.qoiu.calculator.domain.model.CalculatorObject

class OperandLong(value: String) :
    BaseOperand<Long>(value) {

    override fun fixValue(): CalculatorObject.Operand {
        return if(super.fixValue() is OperandLong){
            value = value.toLong().toString()
            this
        }else
            super.fixValue()
    }

    override fun value(): Long = this.value.toLong()
}