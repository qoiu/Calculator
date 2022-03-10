package com.github.qoiu.calculator.domain.model

data class TestCase(
    val o1: String,
    val o2: String,
    val expected: Calculator.Operand<*>,
)