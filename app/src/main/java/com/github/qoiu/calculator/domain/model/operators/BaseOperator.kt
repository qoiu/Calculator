package com.github.qoiu.calculator.domain.model.operators

import com.github.qoiu.calculator.domain.model.Calculator
import com.github.qoiu.calculator.domain.model.operands.OperandEmpty


abstract class BaseOperator(
    protected val operand: Calculator,
    protected var operand2: Calculator = OperandEmpty()
) : Calculator.Operator, Calculator.OperatorDecimal {

    override fun result(): Calculator.Operand =
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

    override fun append(operator: Calculator.Operator): Calculator.Operator {
        return if (operand2 is OperandEmpty)
            operator.init(operand)
        else
            if (weight() < operator.weight()) {
                operand2 = operator.init(operand2)
                this
            } else {
                operator.init(this)
            }
    }

    override fun delete(): Calculator {
        if (operand2 !is OperandEmpty) {
            this.operand2 = operand2.delete()
            if (operand2 is Calculator.Operand) operand2 =
                (operand2 as Calculator.Operand).fixValue()
            return this
        }
        return operand
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BaseOperator

        if (operand != other.operand) return false
        if (operand2 != other.operand2) return false

        return true
    }

    override fun hashCode(): Int {
        var result = operand.hashCode()
        result = 31 * result + operand2.hashCode()
        return result
    }
}