 package com.github.qoiu.calculator.data

import org.junit.Assert.*

import org.junit.Test
import java.math.BigDecimal

class BufferMemoryTest {

    @Test
    fun plus() {
        val buffer = BufferMemory.Base()
        buffer.save(BigDecimal.valueOf(25))
        buffer.plus(BigDecimal.valueOf(5))
        buffer.minus(BigDecimal.valueOf(10))
        assertEquals("20",buffer.read())
    }
}