package com.github.qoiu.calculator.domain.model

abstract class BaseCalculatorObject: CalculatorObject {

    override fun closeOpenedJoin(hasOpenJoin: Boolean): Boolean = hasOpenJoin
}