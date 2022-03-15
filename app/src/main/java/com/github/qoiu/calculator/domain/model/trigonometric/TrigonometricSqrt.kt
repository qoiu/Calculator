package com.github.qoiu.calculator.domain.model.trigonometric

import com.github.qoiu.calculator.domain.model.CalculatorObject
import com.github.qoiu.calculator.domain.model.RadDegSwitcher
import kotlin.math.sqrt

class TrigonometricSqrt(value: String = "", switcher: RadDegSwitcher = RadDegSwitcher.Base()) : BaseTrigonometricOperand(value,switcher) {
    override fun init(calculator: CalculatorObject): CalculatorObject.Trigonometric =
        TrigonometricSqrt(calculator.result().toString())

    override fun operation(double: Double): Double = sqrt(value())

    override fun toString(): String = "√($value)"
}