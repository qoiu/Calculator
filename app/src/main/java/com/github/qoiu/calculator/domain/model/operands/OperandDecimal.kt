package com.github.qoiu.calculator.domain.model.operands

import com.github.qoiu.calculator.domain.model.Calculator
import java.math.BigDecimal

class OperandDecimal(value: String) :
    BaseOperand<BigDecimal>(value) {
    override fun value(): BigDecimal = value.toBigDecimal()

    override fun fixValue(): Calculator.Operand {
        if (value.toDouble().toString().contains('E') || value.contains('E'))
            return OperandDouble(value.toDouble().toString())
        if (value.length > 15) {
            OperandDouble(value.toDouble().toString()).fixValue()
        }
        return simplify()
    }

    private fun simplify(): Calculator.Operand {
        for (i in value.length - 1 downTo 1) {
            if (value.contains('.') && value[i] == '0' || value[i] == '.') {
                value = value.substring(0, i)
            } else {
                return super.fixValue()
            }
        }
        return super.fixValue()
    }
}