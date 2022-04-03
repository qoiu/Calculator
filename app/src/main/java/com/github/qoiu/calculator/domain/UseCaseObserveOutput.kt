package com.github.qoiu.calculator.domain

import com.github.qoiu.calculator.domain.model.OutputResult

interface UseCaseObserveOutput {
    suspend fun subscribe(action: (OutputResult)->Unit)
}