package com.github.qoiu.calculator.domain.model.operators

import com.github.qoiu.calculator.domain.model.CalculatorObject
import com.github.qoiu.calculator.domain.model.operands.OperandDecimal
import com.github.qoiu.calculator.domain.model.operands.OperandEmpty
import java.math.BigDecimal
import java.math.RoundingMode

class OperatorDiv(operand: CalculatorObject = OperandEmpty(), operand2: CalculatorObject = OperandEmpty()) :
    BaseOperator(operand, operand2) {

    override fun toString() = "$operand/$operand2"

    override fun operation(o1: BigDecimal, o2: BigDecimal): CalculatorObject.Operand {
        val result = o1.divide(o2, 10, RoundingMode.HALF_UP).toString()
        return OperandDecimal(result).fixValue()
    }

    override fun init(calculator: CalculatorObject) = OperatorDiv(calculator)

    override fun weight(): Int = WEIGHT

    private companion object {
        private const val WEIGHT = 2
    }
}