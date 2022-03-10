package com.github.qoiu.calculator.domain.model

sealed class Calculator {

    abstract fun result(): Operand<*>
    abstract fun append(symbol: String): Calculator
    abstract fun delete(): Calculator

    abstract class Operand<T : Number>(
        protected var value: String,
        private val weight: Int,
        private val lengthMax: Int
    ) : Calculator() {
        override fun result(): Operand<*> = this
        override fun append(symbol: String): Operand<*> {
            this.value = "$value$symbol"
            return classCheck()
        }

        override fun delete(): Operand<*> {
            if (value.isNotEmpty()) {
                this.value = value.substring(0, value.length - 1)
            }
            return classCheck()
        }

        private fun checkLength() {
            if (value.length > lengthMax)
                throw java.lang.IllegalStateException("You can use only $lengthMax symbols")
        }

        fun classCheck(): Operand<*> {
            if (value.isBlank())
                return OperandEmpty()
            return if (value.contains('.')) {
                if (value.length > 9) {
                    toDecimal()
                } else {
                    toDouble()
                }
            } else {
                checkLength()
                toLong()
            }
        }

        fun simplify(): Operand<*> =
            try {
                val dob = value.toDouble()
                val long = dob.toLong()
                if (dob.equals(long.toDouble())) {
                    this.value = long.toString()
                }
                classCheck()
            } catch (e: Exception) {
                println(e.message)
                classCheck()
            }

        fun compareTypeWith(operand: Operand<*>): Operand<*> =
            when (operand.weight.coerceAtLeast(this.weight)) {
                1 -> toLong()
                2 -> toDouble()
                3 -> toDecimal()
                else -> {
                    throw java.lang.ClassCastException("Error in Operand type compare: Unknown class")
                }
            }

        /**
         * This method should return classCheck() call
         */
        abstract fun plus(operand: Operand<T>): Operand<*>

        /**
         * This method should return classCheck() call
         */
        abstract fun minus(operand: Operand<T>): Operand<*>

        fun toLong() = OperandLong(value)
        fun toDouble() = OperandDouble(value)
        fun toDecimal() = OperandDecimal(value)

        override fun toString(): String = value

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Operand<*>

            if (value != other.value) return false

            return true
        }

        override fun hashCode(): Int {
            return value.hashCode()
        }
    }

    abstract class Operator(
        protected val operand: Operand<*>,
        protected var operand2: Operand<*> = OperandEmpty()
    ) : Calculator() {


        abstract fun <T : Number> operation(
            o1: Operand<T>,
            o2: Operand<*>
        ): Operand<*>

        override fun result(): Operand<*> {
            val o1 = operand.compareTypeWith(operand2)
            val o2 = operand2.compareTypeWith(operand)
            return operation(o1, o2)
        }

        override fun append(symbol: String): Calculator {
            this.operand2 = operand2.append(symbol)
            return this
        }

        override fun delete(): Calculator {
            return if (operand2 is OperandEmpty)
                operand
            else {
                this.operand2 = operand2.delete()
                this
            }
        }
    }
}