package com.github.qoiu.calculator.domain

import com.github.qoiu.calculator.data.BufferMemory
import com.github.qoiu.calculator.data.CalculatorMemory
import com.github.qoiu.calculator.domain.model.OutputResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest

class CalculatorInteractor(private val memory: CalculatorMemory, private val buffer: BufferMemory) :
    UseCaseAppend,
    UseCaseObserveOutput {

    private val mutableStateFlow = MutableStateFlow<OutputResult>(OutputResult.Success(""))

    override suspend fun subscribe(action: (OutputResult) -> Unit) {
        mutableStateFlow.collectLatest(action)
    }

    override fun appendNumber(value: String) {
        try {
            memory.append(value)
            output()
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
                "^" -> memory.pow()
                "√" -> memory.sqrt()
                "=" -> memory.rewrite()
                "+/-" -> memory.mod()
                "π" -> memory.const(value)
                "e" -> memory.const(value)
                "Rad" -> memory.switchRad()
                "Deg" -> memory.switchDeg()
                "Sin" -> memory.sin()
                "Cos" -> memory.cos()
                "m+" -> buffer.plus(memory.result().toBigDecimal())
                "m-" -> buffer.minus(memory.result().toBigDecimal())
                "mc" -> buffer.clear()
                "mr" -> memory.set(buffer.read())
                "()" -> memory.join()
                "Del" -> memory.delete()
                "C" -> memory.clear()
                else -> throw IllegalStateException("Unknown operator")
            }
            output()
        } catch (e: Exception) {
            mutableStateFlow.value = OutputResult.Error(e)
        }
    }

    private fun output() {
        val output = memory.output()
        val result = memory.result()
        mutableStateFlow.value = if (output != result)
            OutputResult.Success(output, result)
        else
            OutputResult.Success(result)
    }
}