package com.github.qoiu.calculator.domain.model.operators

import com.github.qoiu.calculator.domain.model.operands.Operand
import com.github.qoiu.calculator.domain.model.operands.OperandDecimal
import com.github.qoiu.calculator.domain.model.operands.OperandDouble
import com.github.qoiu.calculator.domain.model.operands.OperandLong
import java.math.BigDecimal

class OperatorAdd(operand: Operand<*>) : Operator(operand) {

    override fun toString() = "$operand+$operand2"

    override fun operation(o1: Long, o2: Long): Operand<*> =
        OperandLong(o1.plus(o2).toString()).fixValue()

    override fun operation(o1: Double, o2: Double): Operand<*> =
        OperandDouble(o1.plus(o2).toString()).fixValue()

    override fun operation(o1: BigDecimal, o2: BigDecimal): Operand<*> =
        OperandDecimal(o1.plus(o2).toString()).fixValue()
}