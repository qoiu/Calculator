package com.github.qoiu.calculator.domain.model

import com.github.qoiu.calculator.domain.model.operands.BaseOperand

data class TestCase(
    val o1: String,
    val o2: String,
    val expected: BaseOperand<*>,
)