package com.github.qoiu.calculator.domain.model.operators

import com.github.qoiu.calculator.domain.model.*
import com.github.qoiu.calculator.domain.model.operands.*


abstract class Operator(
    protected val operand: Calculator,
    private val weight: Int = 0,
    protected var operand2: Operand<*> = OperandEmpty()
) : Calculator, Operation.OperationDecimal {

    override fun result(): Operand<*> =
        if (operand is Operator && weight >= operand.weight) {
            val preResult = operation(
                operand.operand2.result().toOperandDecimal().value(),
                operand2.toOperandDecimal().value()
            ).fixValue()
            operand.operation(
                operand.operand.result().toOperandDecimal().value(),
                preResult.result().toOperandDecimal().value()
            )
        } else {
            operation(
                operand.result().toOperandDecimal().value(),
                operand2.toOperandDecimal().value()
            ).fixValue()
        }

    override fun append(symbol: String): Calculator {
        this.operand2 = operand2.append(symbol)
        return this
    }

    override fun delete(): Calculator {
        if (operand2 !is OperandEmpty) {
            this.operand2 = operand2.delete()
            return this
        }
        return operand.result()
    }
}