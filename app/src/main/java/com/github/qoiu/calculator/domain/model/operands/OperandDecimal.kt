package com.github.qoiu.calculator.domain.model.operands

import com.github.qoiu.calculator.domain.model.CalculatorObject
import java.math.BigDecimal

class OperandDecimal(value: String) :
    BaseOperand<BigDecimal>(value) {
    override fun value(): BigDecimal = value.toBigDecimal()

    override fun fixValue(): CalculatorObject.Operand {
        if (value.toDouble().toString().contains('E') || value.contains('E'))
            return OperandDouble(value.toDouble().toString())
        if (value.length > 15) {
            OperandDouble(value.toDouble().toString()).fixValue()
        }
        return simplify()
    }

    override fun mod() {
        value = value().negate().toString()
    }

    private fun simplify(): CalculatorObject.Operand {
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