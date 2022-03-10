package com.github.qoiu.calculator.domain.model


class OperatorAdd(operand: Operand<*>) : Calculator.Operator(operand) {
    @SuppressWarnings("unchecked")
    override fun <T : Number> operation(o1: Operand<T>, o2: Operand<*>): Operand<*> {
        return if (o1.javaClass == o2.javaClass) {
            o1.plus(o2 as Operand<T>)
        } else {
            throw ClassCastException("Different operand")
        }
    }

    override fun toString() = "$operand+$operand2"
}

class OperatorSub(operand: Operand<*>): Calculator.Operator(operand){
    override fun <T : Number> operation(o1: Operand<T>, o2: Operand<*>): Operand<*> {
        return if (o1.javaClass == o2.javaClass) {
            o1.minus(o2 as Operand<T>)
        } else {
            throw ClassCastException("Different operand")
        }
    }


    override fun toString() = "$operand-$operand2"
}