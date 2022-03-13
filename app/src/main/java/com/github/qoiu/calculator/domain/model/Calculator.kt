package com.github.qoiu.calculator.domain.model

import com.github.qoiu.calculator.domain.model.operands.OperandDecimal
import com.github.qoiu.calculator.domain.model.operands.OperandDouble
import com.github.qoiu.calculator.domain.model.operands.OperandLong
import java.math.BigDecimal

interface Calculator {
    /**
     * @return result of operation/operand as Operand
     */
    fun result(): Operand

    /**
     * Append any symbol like numbers
     * @return Operand with different value
     */
    fun append(symbol: String): Calculator

    /**
     * Apply new Operator and return it
     */
    fun append(operator: Operator): Operator

    /**
     * Delete last symbol from expression
     * @return new expression
     */
    fun delete(): Calculator

    interface Operator: Calculator {
        fun init(calculator: Calculator): Operator

        /**
         * Weight of operation define it sequence
         */
        fun weight(): Int
    }

    interface OperatorDecimal {
        fun operation(o1: BigDecimal, o2: BigDecimal): Operand
    }

    interface Operand: Calculator {
        fun toOperandLong(): OperandLong
        fun toOperandDouble(): OperandDouble
        fun toOperandDecimal(): OperandDecimal

        /**
         * This method shouldn't have any side effects. You may decide if you want to apply changes
         * by using result
         * @return class which is better to perform this value
         */
        fun fixValue(): Operand
    }
}