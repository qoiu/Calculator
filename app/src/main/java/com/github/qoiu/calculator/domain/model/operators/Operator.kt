package com.github.qoiu.calculator.domain.model.operators

import com.github.qoiu.calculator.domain.model.*
import com.github.qoiu.calculator.domain.model.operands.*


abstract class Operator(
    protected val operand: Operand<*>,
    protected var operand2: Operand<*> = OperandEmpty()
) : Calculator, Operation.All {

    override fun result(): Operand<*> =
        when (val o1 = operand.compareTypeWith(operand2)) {
            is OperandLong -> {
                operation(o1.value(), operand2.toOperandLong().value())
            }
            is OperandDouble -> {
                operation(o1.value(), operand2.toOperandDouble().value())
            }
            is OperandDecimal -> {
                operation(o1.value(), operand2.toOperandDecimal().value())
            }
            else ->
                throw IllegalStateException("empty value")
        }

    override fun append(symbol: String): Calculator {
        this.operand2 = operand2.append(symbol)
        return this
    }

    override fun delete(): Calculator {
        return if (operand2 is OperandEmpty)
            operand
        else {
            this.operand2 = operand2.delete()
            this
        }
    }
}