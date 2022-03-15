package com.github.qoiu.calculator.domain.model.operands

import com.github.qoiu.calculator.domain.model.CalculatorObject
import java.lang.IllegalStateException

open class OperandDouble(value: String) :
    BaseOperand<Double>(value) {

    override fun fixValue(): CalculatorObject.Operand {
        if (value.isNotEmpty() && value.toDouble() > Double.MAX_VALUE) throw IllegalStateException("Number is too big")
        return try {
            val doubleValue = value.toDouble()
            val longValue = doubleValue.toLong()
            if (doubleValue.equals(longValue.toDouble())) {
                OperandLong(longValue.toString())
            } else {
                super.fixValue()
            }
        } catch (e: Exception) {
            println(e.toString())
            super.fixValue()
        }
    }

    override fun mod() {
        value = (value()*-1).toString()
    }

    override fun value(): Double = value.toDouble()
}