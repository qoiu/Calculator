package com.github.qoiu.calculator.domain.model.operands

import com.github.qoiu.calculator.domain.model.Calculator

open class OperandDouble(value: String) :
    BaseOperand<Double>(value) {

    override fun fixValue(): Calculator.Operand =
        try {
            val doubleValue = value.toDouble()
            val longValue = doubleValue.toLong()
            if (doubleValue.equals(longValue.toDouble())) {
                OperandLong(longValue.toString())
            }else{
                super.fixValue()
            }
        } catch (e: Exception) {
            println(e.toString())
            super.fixValue()
        }

    override fun value(): Double = value.toDouble()
}