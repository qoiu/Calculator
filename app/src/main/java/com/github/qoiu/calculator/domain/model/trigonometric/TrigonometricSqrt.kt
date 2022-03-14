package com.github.qoiu.calculator.domain.model.trigonometric

import com.github.qoiu.calculator.domain.model.CalculatorObject
import kotlin.math.sqrt

class TrigonometricSqrt(value: String = "") : BaseTrigonometricOperand(value) {
    override fun init(calculator: CalculatorObject): CalculatorObject.Trigonometric =
        TrigonometricSqrt(calculator.result().toString())

    override fun operation(double: Double): Double = sqrt(double)

    override fun toString(): String = "√($value)"
}