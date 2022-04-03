package com.github.qoiu.calculator.domain.model.operators

import com.github.qoiu.calculator.domain.model.CalculatorObject
import com.github.qoiu.calculator.domain.model.operands.OperandDecimal
import com.github.qoiu.calculator.domain.model.operands.OperandEmpty
import java.math.BigDecimal

class OperatorSub(operand: CalculatorObject = OperandEmpty(), operand2: CalculatorObject = OperandEmpty()) :
    BaseOperator(operand, operand2) {
    override fun toString() = "$operand-$operand2"

    override fun operation(o1: BigDecimal, o2: BigDecimal): CalculatorObject.Operand =
        OperandDecimal(o1.minus(o2).toString()).fixValue()

    override fun weight(): Int = WEIGHT

    private companion object {
        private const val WEIGHT = 1
    }

    override fun init(calculator: CalculatorObject) = OperatorSub(calculator)
}