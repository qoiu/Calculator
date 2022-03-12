package com.github.qoiu.calculator.domain.model.operands

import java.math.BigDecimal

class OperandDecimal(value: String) :
    Operand<BigDecimal>(value, 50) {
    override fun value(): BigDecimal = value.toBigDecimal()

    override fun fixValue(): Operand<*> {
        if (value.toDouble().toString().contains('E') || value.contains('E'))
            return OperandDouble(value.toDouble().toString())
        if (value.length > 15) {
            OperandDouble(value.toDouble().toString()).classCheck()
        }
        return simplify()
    }

    private fun simplify(): Operand<*> {
        for (i in value.length - 1 downTo 1) {
            if (value.contains('.') && value[i] == '0' || value[i] == '.') {
                value = value.substring(0, i)
            } else {
                return classCheck()
            }
        }
        return classCheck()
    }
}