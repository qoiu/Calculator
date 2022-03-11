package com.github.qoiu.calculator.domain.model

import java.lang.Exception

sealed class OutputResult {

    data class Success(val arguments: String, val result: String = "") : OutputResult()
    data class Error(val e: Exception) : OutputResult()
}