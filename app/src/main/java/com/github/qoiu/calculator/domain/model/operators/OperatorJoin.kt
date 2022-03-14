package com.github.qoiu.calculator.domain.model.operators

import com.github.qoiu.calculator.domain.model.CalculatorObject
import com.github.qoiu.calculator.domain.model.operands.OperandEmpty

data class OperatorJoin(
    private var operand: CalculatorObject = OperandEmpty(),
    private var isOpen: Boolean = true
) :
    CalculatorObject.Operator {

    override fun toString() = if (isOpen) "($operand" else "($operand)"

    override fun append(symbol: String): CalculatorObject {
        operand = operand.append(symbol)
        return this
    }

    override fun append(operator: CalculatorObject.Operator): CalculatorObject {
        if (!isOpen) return operator.init(this)
        return if (operator is OperatorJoin && operand !is OperandEmpty) {
            isOpen = false
            this
        } else {
            operand = operand.append(operator)
            this
        }
    }

    override fun append(operator: CalculatorObject.Trigonometric): CalculatorObject {
        operand = operator.init(operand)
        return this
    }

    override fun delete(): CalculatorObject {
        if (operand !is OperandEmpty) {
            this.operand = operand.delete()
            if (operand is CalculatorObject.Operand) operand =
                (operand as CalculatorObject.Operand).fixValue()
            return this
        }
        return operand
    }

    override fun result(): CalculatorObject.Operand = operand.result()

    override fun init(calculator: CalculatorObject): CalculatorObject = OperatorJoin(calculator)

    override fun weight(): Int = 15
}