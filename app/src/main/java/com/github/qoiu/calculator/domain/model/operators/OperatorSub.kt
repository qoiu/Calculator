package com.github.qoiu.calculator.domain.model.operators

import com.github.qoiu.calculator.domain.model.Calculator
import com.github.qoiu.calculator.domain.model.operands.Operand
import com.github.qoiu.calculator.domain.model.operands.OperandDecimal
import java.math.BigDecimal

class OperatorSub(operand: Calculator) : Operator(operand) {
    override fun toString() = "$operand-$operand2"

    override fun operation(o1: BigDecimal, o2: BigDecimal): Operand<*> =
        OperandDecimal(o1.minus(o2).toString()).fixValue()
}