package io.github.lumkit.fluent2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fluent2_compose_multiplatform.simple.generated.resources.Res
import fluent2_compose_multiplatform.simple.generated.resources.compose_multiplatform
import io.github.lumkit.fluent2.ui.*
import org.jetbrains.compose.resources.painterResource
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
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Button(onClick = { isDark = !isDark }) {
                    Text(if (isDark) "Dark" else "Light")
                }

                Button(
                    onClick = {

                    }
                ) {
                    Text(text = "Primary Button")
                }

                DefaultButton(
                    onClick = {

                    }
                ) {
                    Text(text = "Default Button")
                }

                OutlineButton(
                    onClick = {

                    }
                ) {
                    Text(text = "Outline Button")
                }

                SubtleButton(
                    onClick = {

                    }
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.compose_multiplatform),
                        contentDescription = null,
                        tint = LocalIconColor.current,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(text = "Subtle Button")
                }

                TransparentButton(
                    onClick = {

                    }
                ) {
                    Text(text = "Transparent Button")
                }
            }
        }
    }
}