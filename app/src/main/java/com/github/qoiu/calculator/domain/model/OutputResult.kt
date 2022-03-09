package com.github.qoiu.calculator.domain.model

import java.lang.Exception

sealed class OutputResult {

    class Success(val result: List<Calculator>) : OutputResult()
    class Error(val e: Exception) : OutputResult()
}