package io.github.lumkit.fluent2

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "fluent2",
    ) {
        App()
    }
}