package com.github.qoiu.calculator.domain.model.operators

import com.github.qoiu.calculator.domain.model.Calculator
import com.github.qoiu.calculator.domain.model.operands.Operand
import com.github.qoiu.calculator.domain.model.operands.OperandEmpty


abstract class Operator(
    protected val operand: Calculator,
    protected var operand2: Calculator = OperandEmpty()
) : Calculator, Operation.OperationDecimal {

    override fun result(): Operand<*> =
        if (operand2 is OperandEmpty)
            operand.result()
        else
            operation(
                operand.result().toOperandDecimal().value(),
                operand2.result().toOperandDecimal().value()
            ).fixValue().result()

    override fun append(symbol: String): Calculator {
        this.operand2 = operand2.append(symbol)
        return this
    }

    override fun append(operator: Operator): Operator {
        if (operand2 is OperandEmpty)
            return if (operand is Operator) {
                operand.append(operator)
            } else {
                operator.init(operand)
            }
        return if (weight() < operator.weight()) {
            operand2 = operator.init(operand2)
            this
        } else {
            operator.init(this)
        }
    }

    override fun delete(): Calculator {
        if (operand2 !is OperandEmpty) {
            this.operand2 = operand2.delete()
            return this
        }
        return operand
    }
}