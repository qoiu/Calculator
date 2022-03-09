package com.github.qoiu.calculator.domain

import com.github.qoiu.calculator.data.CalculatorMemory
import com.github.qoiu.calculator.domain.model.OutputResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest

class CalculatorInteractor(private val memory: CalculatorMemory) : UseCaseAppend,
    UseCaseObserveOutput {

    private val mutableStateFlow = MutableStateFlow<OutputResult>(OutputResult.Success(emptyList()))

    override suspend fun subscribe(action: (OutputResult) -> Unit) {
        mutableStateFlow.collectLatest(action)
    }

    override fun append(value: String) {
        try {
            memory.append(value)
            mutableStateFlow.value = OutputResult.Success(memory.output())
        } catch (e: Exception) {
            mutableStateFlow.value = OutputResult.Error(e)
        }
    }
}