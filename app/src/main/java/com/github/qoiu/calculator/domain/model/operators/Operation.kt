package com.github.qoiu.calculator.domain.model.operators

import com.github.qoiu.calculator.domain.model.Calculator
import com.github.qoiu.calculator.domain.model.operands.Operand
import java.math.BigDecimal

interface Operation {
    fun append(operator: Operator): Operator
    fun append(operator: OperatorJoin): Operator
    fun init(calculator: Calculator): Operator
    fun weight(): Int
    interface OperationDecimal: Operation {
        fun operation(o1: BigDecimal, o2: BigDecimal): Operand<*>
    }
}