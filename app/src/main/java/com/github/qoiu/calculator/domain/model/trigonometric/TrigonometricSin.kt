package com.github.qoiu.calculator.domain.model.trigonometric

import com.github.qoiu.calculator.domain.model.CalculatorObject
import com.github.qoiu.calculator.domain.model.RadDegSwitcher
import kotlin.math.sin

class TrigonometricSin(value: String = "", private val switcher: RadDegSwitcher = RadDegSwitcher.Base()) : BaseTrigonometricOperand(value,switcher) {
    override fun init(calculator: CalculatorObject): CalculatorObject.Trigonometric =
        TrigonometricSin(calculator.result().toString(),switcher)

    override fun operation(double: Double): Double = sin(double)

    override fun toString(): String = "sin($value)"
}