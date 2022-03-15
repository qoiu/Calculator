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
                UiKey.Operator(actions, "√"),
                UiKey.Operator(actions, "C"),
                UiKey.Operator(actions, "Del"),
                UiKey.Operator(actions, "+"),
                UiKey.Number(actions, "7"),
                UiKey.Number(actions, "8"),
                UiKey.Number(actions, "9"),
                UiKey.Operator(actions, "-"),
                UiKey.Number(actions, "4"),
                UiKey.Number(actions, "5"),
                UiKey.Number(actions, "6"),
                UiKey.Operator(actions, "*"),
                UiKey.Number(actions, "1"),
                UiKey.Number(actions, "2"),
                UiKey.Number(actions, "3"),
                UiKey.Operator(actions, "/"),
                UiKey.Number(actions, "+/-"),
                UiKey.Number(actions, "0"),
                UiKey.Operator(actions, "."),
                UiKey.Operator(actions, "=")
            )
    }

    class Extra(actions: KeyboardActions) : Keyboard {

        override val cells = 6
        override val list: List<UiKey> =
            listOf(
                UiKey.Operator(actions, "√"),
                UiKey.Operator(actions, "^"),
                UiKey.Switcher(actions, "Rad", "Deg"),
                UiKey.Operator(actions, "C"),
                UiKey.Operator(actions, "Del"),
                UiKey.Operator(actions, "/"),

                UiKey.Operator(actions, "m+"),
                UiKey.Operator(actions, "m-"),
                UiKey.Number(actions, "7"),
                UiKey.Number(actions, "8"),
                UiKey.Number(actions, "9"),
                UiKey.Operator(actions, "*"),

                UiKey.Operator(actions, "mc"),
                UiKey.Operator(actions, "mr"),
                UiKey.Number(actions, "4"),
                UiKey.Number(actions, "5"),
                UiKey.Number(actions, "6"),
                UiKey.Operator(actions, "-"),

                UiKey.Operator(actions, "Sin"),
                UiKey.Operator(actions, "Cos"),
                UiKey.Number(actions, "3"),
                UiKey.Number(actions, "2"),
                UiKey.Number(actions, "1"),
                UiKey.Operator(actions, "+"),

                UiKey.Operator(actions, "π"),
                UiKey.Operator(actions, "e"),
                UiKey.Operator(actions, "+/-"),
                UiKey.Number(actions, "0"),
                UiKey.Number(actions, "."),
                UiKey.Operator(actions, "=")
            )
    }
}