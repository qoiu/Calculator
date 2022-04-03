package com.github.qoiu.calculator.domain

interface UseCaseAppend {
    fun appendNumber(value: String)
    fun appendOperator(value: String)
}