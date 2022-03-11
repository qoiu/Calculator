package com.github.qoiu.calculator.domain.model.operands

interface OperandMethods {
    fun toOperandLong(): OperandLong
    fun toOperandDouble(): OperandDouble
    fun toOperandDecimal(): OperandDecimal
    fun fixValue(): Operand<*>
}