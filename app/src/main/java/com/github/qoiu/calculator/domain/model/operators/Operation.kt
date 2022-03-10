package com.github.qoiu.calculator.domain.model.operators

import com.github.qoiu.calculator.domain.model.operands.Operand
import java.math.BigDecimal

interface Operation {
    interface OperationLong {
        fun operation(o1: Long, o2: Long): Operand<*>
    }

    interface OperationDouble {
        fun operation(o1: Double, o2: Double): Operand<*>
    }

    interface OperationDecimal {
        fun operation(o1: BigDecimal, o2: BigDecimal): Operand<*>
    }

    interface All : OperationLong, OperationDouble, OperationDecimal
}