package com.github.qoiu.calculator.domain.model.operators

import com.github.qoiu.calculator.domain.model.Calculator
import com.github.qoiu.calculator.domain.model.operands.OperandDecimal
import com.github.qoiu.calculator.domain.model.operands.OperandEmpty
import java.math.BigDecimal

class OperatorPow(operand: Calculator = OperandEmpty(), operand2: Calculator = OperandEmpty()) :
    BaseOperator(operand, operand2) {
    override fun toString() = "$operand^($operand2)"

    override fun operation(o1: BigDecimal, o2: BigDecimal): Calculator.Operand =
        OperandDecimal(o1.pow(o2.toInt()).toString()).fixValue()

    override fun weight(): Int = WEIGHT

    private companion object {
        private const val WEIGHT = 10
    }

    override fun init(calculator: Calculator) = OperatorPow(calculator)
}