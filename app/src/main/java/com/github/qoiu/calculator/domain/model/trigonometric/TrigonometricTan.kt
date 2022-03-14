package com.github.qoiu.calculator.domain.model.trigonometric

import com.github.qoiu.calculator.domain.model.CalculatorObject
import kotlin.math.tan

class TrigonometricTan(value: String = "") : BaseTrigonometricOperand(value) {
    override fun init(calculator: CalculatorObject): CalculatorObject.Trigonometric =
        TrigonometricTan(calculator.result().toString())

    override fun operation(double: Double): Double = tan(double)

    override fun toString(): String = "tan($value)"
}