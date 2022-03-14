package com.github.qoiu.calculator.domain.model.trigonometric

import com.github.qoiu.calculator.domain.model.CalculatorObject
import kotlin.math.sin

class TrigonometricSin(value: String = "") : BaseTrigonometricOperand(value) {
    override fun init(calculator: CalculatorObject): CalculatorObject.Trigonometric =
        TrigonometricSin(calculator.result().toString())

    override fun operation(double: Double): Double = sin(double)

    override fun toString(): String = "sin($value)"
}