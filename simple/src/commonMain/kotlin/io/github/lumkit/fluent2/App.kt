package io.github.lumkit.fluent2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.lumkit.fluent2.ui.*
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    var isDark by remember { mutableStateOf(false) }
    FluentTheme(
        colorScheme = if (isDark) darkScheme else lightScheme,
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = FluentTheme.colorScheme.background
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Button(onClick = { isDark = !isDark }) {
                    Text(if (isDark) "Dark" else "Light")
                }

                Button(
                    onClick = {

                    }
                ) {
                    Text(text = "Fluent Design 2")
                }

                DefaultButton(
                    onClick = {

                    }
                ) {
                    Text(text = "Fluent Design 2")
                }

                OutlineButton(
                    onClick = {

                    }
                ) {
                    Text(text = "Fluent Design 2")
                }

                SubtleButton(
                    onClick = {

                    }
                ) {
                    Text(text = "Fluent Design 2")
                }

                TransparentButton(
                    onClick = {

                    }
                ) {
                    Text(text = "Fluent Design 2")
                }
            }
        }
    }
}