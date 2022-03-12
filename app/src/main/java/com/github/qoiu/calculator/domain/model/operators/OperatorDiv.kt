package com.github.qoiu.calculator.domain.model.operators

import com.github.qoiu.calculator.domain.model.Calculator
import com.github.qoiu.calculator.domain.model.operands.Operand
import com.github.qoiu.calculator.domain.model.operands.OperandDecimal
import com.github.qoiu.calculator.domain.model.operands.OperandEmpty
import java.math.BigDecimal
import java.math.RoundingMode

class OperatorDiv(operand: Calculator = OperandEmpty(), operand2: Calculator = OperandEmpty()) :
    Operator(operand, operand2) {

    override fun toString() = "$operand/$operand2"

    override fun operation(o1: BigDecimal, o2: BigDecimal): Operand<*> {
        val result = o1.divide(o2, 10, RoundingMode.HALF_UP).toString()
        return OperandDecimal(result).fixValue()
    }

    override fun init(calculator: Calculator) = OperatorDiv(calculator)

    override fun weight(): Int = WEIGHT

    private companion object {
        private const val WEIGHT = 3
    }
}