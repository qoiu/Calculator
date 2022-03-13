package com.github.qoiu.calculator.domain.model.operands

import kotlin.math.sin

class OperandSin(value: String = "") : OperandTrigonometric(value) {
    override fun operation(double: Double): Double = sin(double)

    override fun toString(): String = "sin($value)"
}