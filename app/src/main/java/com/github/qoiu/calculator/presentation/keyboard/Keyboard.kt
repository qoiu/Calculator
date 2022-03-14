package com.github.qoiu.calculator.presentation.keyboard

import com.github.qoiu.calculator.presentation.UiKey

interface Keyboard {
    val list: List<UiKey>
    val cells: Int

    class Default(actions: KeyboardActions) : Keyboard {
        override val cells = 4
        override val list: List<UiKey> =
            listOf(
                UiKey.Operator(actions, "m+"),
                UiKey.Operator(actions, "m-"),
                UiKey.Operator(actions, "ms"),
                UiKey.Operator(actions, "mr"),
                UiKey.Operator(actions, "()"),
                UiKey.Operator(actions, "^"),
                UiKey.Operator(actions, "C"),
                UiKey.Operator(actions, "Del"),
                UiKey.Number(actions, "7"),
                UiKey.Number(actions, "8"),
                UiKey.Number(actions, "9"),
                UiKey.Operator(actions, "+"),
                UiKey.Number(actions, "4"),
                UiKey.Number(actions, "5"),
                UiKey.Number(actions, "6"),
                UiKey.Operator(actions, "-"),
                UiKey.Number(actions, "1"),
                UiKey.Number(actions, "2"),
                UiKey.Number(actions, "3"),
                UiKey.Operator(actions, "*"),
                UiKey.Number(actions, "."),
                UiKey.Number(actions, "0"),
                UiKey.Operator(actions, "="),
                UiKey.Operator(actions, "/")
            )
    }

    class Extra(actions: KeyboardActions) : Keyboard {

        override val cells = 5
        override val list: List<UiKey> =
            listOf(
                UiKey.Operator(actions, "sin"),
                UiKey.Operator(actions, "^"),
                UiKey.Operator(actions, "C"),
                UiKey.Operator(actions, "Del"),
                UiKey.Number(actions, "7"),
                UiKey.Number(actions, "8"),
                UiKey.Number(actions, "9"),
                UiKey.Operator(actions, "+"),
                UiKey.Operator(actions, "m+"),
                UiKey.Number(actions, "4"),
                UiKey.Number(actions, "5"),
                UiKey.Number(actions, "6"),
                UiKey.Operator(actions, "-"),
                UiKey.Operator(actions, "m-"),
                UiKey.Number(actions, "1"),
                UiKey.Number(actions, "2"),
                UiKey.Number(actions, "3"),
                UiKey.Operator(actions, "*"),
                UiKey.Operator(actions, "ms"),
                UiKey.Number(actions, "."),
                UiKey.Number(actions, "0"),
                UiKey.Operator(actions, "="),
                UiKey.Operator(actions, "/"),
                UiKey.Operator(actions, "mr")
            )
    }
}