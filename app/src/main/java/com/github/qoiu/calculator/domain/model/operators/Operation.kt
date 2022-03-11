package com.github.qoiu.calculator.domain.model.operators

import com.github.qoiu.calculator.domain.model.operands.Operand
import java.math.BigDecimal

interface Operation {
    interface OperationDecimal {
        fun operation(o1: BigDecimal, o2: BigDecimal): Operand<*>
    }
}