package com.github.qoiu.calculator.domain

import com.github.qoiu.calculator.data.CalculatorMemory
import com.github.qoiu.calculator.domain.model.OutputResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest

class CalculatorInteractor(private val memory: CalculatorMemory) : UseCaseAppend,
    UseCaseObserveOutput {

    private val mutableStateFlow = MutableStateFlow<OutputResult>(OutputResult.Success(""))

    override suspend fun subscribe(action: (OutputResult) -> Unit) {
        mutableStateFlow.collectLatest(action)
    }

    override fun appendNumber(value: String) {
        try {
            memory.append(value)
            mutableStateFlow.value = OutputResult.Success(memory.output())
        } catch (e: Exception) {
            mutableStateFlow.value = OutputResult.Error(e)
        }
    }

    override fun appendOperator(value: String) {
        try {
            when (value) {
                "+" -> memory.add()
                "-" -> memory.sub()
                "*" -> memory.multiply()
                "/" -> memory.div()
                "=" -> {
                    mutableStateFlow.value = OutputResult.Success(memory.output(), memory.result())
                    return
                }
                "Del" -> memory.delete()
                else -> throw IllegalStateException("Unknown operator")
            }
            mutableStateFlow.value = OutputResult.Success(memory.output())
        } catch (e: Exception) {
            mutableStateFlow.value = OutputResult.Error(e)
        }
    }
}