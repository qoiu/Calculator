package com.github.qoiu.calculator.data

import java.math.BigDecimal

interface BufferMemory {
    fun plus(value: BigDecimal)
    fun minus(value: BigDecimal)
    fun clear()
    fun read(): String

    class Base : BufferMemory {
        private var cell: BigDecimal = BigDecimal.valueOf(0)
        override fun plus(value: BigDecimal) {
            cell = cell.plus(value)
        }

        override fun minus(value: BigDecimal) {
            cell = cell.minus(value)
        }

        override fun clear() {
            cell = BigDecimal(0)
        }

        override fun read(): String = cell.toString()
    }
}