package com.github.qoiu.calculator.domain.model

interface RadDegSwitcher {
    fun toRad()
    fun toDeg()
    fun get(value: Double): Double


    class Base : RadDegSwitcher {
        private var inRad: Boolean = true

        override fun toRad() {
            inRad = true
        }

        override fun toDeg() {
            inRad = false
        }

        override fun get(value: Double): Double = if (inRad) {
            Math.toRadians(value)
        } else {
            Math.toDegrees(value)
        }
    }
}