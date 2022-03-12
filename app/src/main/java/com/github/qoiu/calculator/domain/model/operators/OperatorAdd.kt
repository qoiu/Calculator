package com.github.qoiu.calculator.domain.model.operators

import com.github.qoiu.calculator.domain.model.Calculator
import com.github.qoiu.calculator.domain.model.operands.Operand
import com.github.qoiu.calculator.domain.model.operands.OperandDecimal
import com.github.qoiu.calculator.domain.model.operands.OperandEmpty
import java.math.BigDecimal

class OperatorAdd(operand: Calculator = OperandEmpty(), operand2: Calculator = OperandEmpty()) :
    Operator(operand, operand2) {

    override fun toString() = "$operand+$operand2"

    override fun operation(o1: BigDecimal, o2: BigDecimal): Operand<*> =
        OperandDecimal(o1.plus(o2).toString()).fixValue()

    override fun init(calculator: Calculator) = OperatorAdd(calculator)

    override fun weight(): Int = WEIGHT

    private companion object {
        private const val WEIGHT = 2
    }
}