package com.github.qoiu.calculator.domain.model.operands

import com.github.qoiu.calculator.domain.model.CalculatorObject
import com.github.qoiu.calculator.domain.model.operators.OperatorJoin

class OperandEmpty : BaseOperand<Number>("") {
  override fun result(): BaseOperand<*> = this

    override fun append(operator: CalculatorObject.Trigonometric) = operator

    override fun append(operator: CalculatorObject.Operator): CalculatorObject =
        if(operator is OperatorJoin){
            operator
        }else{
            this
        }

    override fun value(): Number = 0

    override fun toString(): String = ""
}