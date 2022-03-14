package com.github.qoiu.calculator.domain.model.operators

import com.github.qoiu.calculator.domain.model.CalculatorObject
import com.github.qoiu.calculator.domain.model.operands.OperandEmpty

abstract class BaseOperator(
    protected val operand: CalculatorObject,
    protected var operand2: CalculatorObject = OperandEmpty()
) : CalculatorObject.Operator, CalculatorObject.OperatorDecimal {

    override fun result(): CalculatorObject.Operand =
        if (operand2 is OperandEmpty)
            operand.result()
        else
            operation(
                operand.result().toOperandDecimal().value(),
                operand2.result().toOperandDecimal().value()
            ).fixValue().result()

    override fun append(symbol: String): CalculatorObject {
        this.operand2 = operand2.append(symbol)
        return this
    }

    override fun append(operator: CalculatorObject.Operator): CalculatorObject {
        if (operand2 is OperandEmpty)
            return operand.append(operator)
        return if (operator.weight() > weight()) {
            operand2 = operand2.append(operator)
            this
        } else {
            operator.init(this)
        }
    }

    override fun append(operator: CalculatorObject.Trigonometric): CalculatorObject.Operator {
        return if (operand2 is OperandEmpty) {
            operand2 = operator
            this
        } else {
            operand2 = operator.init(operand2)
            this
        }
    }

    override fun delete(): CalculatorObject {
        if (operand2 !is OperandEmpty) {
            this.operand2 = operand2.delete()
            if (operand2 is CalculatorObject.Operand) operand2 =
                (operand2 as CalculatorObject.Operand).fixValue()
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