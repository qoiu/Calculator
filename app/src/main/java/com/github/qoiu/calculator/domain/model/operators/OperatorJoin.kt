package com.github.qoiu.calculator.domain.model.operators

import com.github.qoiu.calculator.domain.model.Calculator
import com.github.qoiu.calculator.domain.model.operands.OperandDecimal
import com.github.qoiu.calculator.domain.model.operands.OperandEmpty
import java.math.BigDecimal

class OperatorJoin(operand: Calculator = OperandEmpty(), operand2: Calculator = OperandEmpty()) :
    BaseOperator(operand,operand2) {
    private var isOpen: Boolean = false
    override fun toString() = if(isOpen)"($operand" else "($operand)"
    override fun operation(o1: BigDecimal, o2: BigDecimal): Calculator.Operand =
        OperandDecimal(o1.toString())

    override fun init(calculator: Calculator): BaseOperator = OperatorJoin(calculator)

    override fun weight(): Int = 15
}