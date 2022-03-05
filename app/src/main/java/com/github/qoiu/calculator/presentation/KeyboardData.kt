package com.github.qoiu.calculator.presentation

class KeyboardData(actions: KeyboardActions) {
    val defaultKeyboard = Keyboard(
        4,
        listOf(
            UiKey.Number(actions, "1"),
            UiKey.Number(actions, "2"),
            UiKey.Number(actions, "3"),
            UiKey.Number(actions, "4"),
            UiKey.Number(actions, "5"),
            UiKey.Number(actions, "6"),
            UiKey.Number(actions, "7"),
            UiKey.Number(actions, "8"),
            UiKey.Number(actions, "9"),
            UiKey.Number(actions, "0"),
            UiKey.Number(actions, ","),
            UiKey.Number(actions, "+"),
            UiKey.Number(actions, "=")
        )
    )
}