package io.github.lumkit.fluent2.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import io.github.lumkit.fluent2.ui.tokens.ShadowTokens

@Composable
fun Modifier.shadow2(): Modifier = shadow(
    ShadowTokens.Shadow2Elevation,
    clip = false
)

@Composable
fun Modifier.shadow4(): Modifier = shadow(
    ShadowTokens.Shadow4Elevation,
    clip = false
)

@Composable
fun Modifier.shadow8(): Modifier = shadow(
    ShadowTokens.Shadow8Elevation,
    clip = false
)

@Composable
fun Modifier.shadow16(): Modifier = shadow(
    ShadowTokens.Shadow16Elevation,
    clip = false
)

@Composable
fun Modifier.shadow28(): Modifier = shadow(
    ShadowTokens.Shadow28Elevation,
    clip = false
)

@Composable
fun Modifier.shadow64(): Modifier = shadow(
    ShadowTokens.Shadow64Elevation,
    clip = false
)