package com.github.qoiu.calculator.domain.model.trigonometric

import com.github.qoiu.calculator.domain.model.CalculatorObject
import kotlin.math.cos

class TrigonometricCos(value: String = "") : BaseTrigonometricOperand(value) {
    override fun init(calculator: CalculatorObject): CalculatorObject.Trigonometric =
        TrigonometricCos(calculator.result().toString())

    override fun operation(double: Double): Double = cos(double)

    override fun toString(): String = "cos($value)"
}