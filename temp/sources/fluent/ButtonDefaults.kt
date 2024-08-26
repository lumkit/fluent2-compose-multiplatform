package io.github.lumkit.fluent2.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.lumkit.fluent2.ui.tokens.FilledButtonTokens

object ButtonDefaults {
    private val ButtonHorizontalPadding = 16.dp
    private val ButtonVerticalPadding = 8.dp

    val ContentPadding =
        PaddingValues(
            start = ButtonHorizontalPadding,
            top = ButtonVerticalPadding,
            end = ButtonHorizontalPadding,
            bottom = ButtonVerticalPadding
        )

    val ContentSpacer = 6.dp

    val shape: Shape @Composable get() = FilledButtonTokens.ContainerShape.value

    @Composable
    fun buttonColors() = FluentTheme.colorScheme.defaultButtonColors

    @Composable
    fun buttonElevation(
        defaultElevation: Dp = FilledButtonTokens.ContainerElevation,
        pressedElevation: Dp = FilledButtonTokens.PressedContainerElevation,
        focusedElevation: Dp = FilledButtonTokens.FocusContainerElevation,
        hoveredElevation: Dp = FilledButtonTokens.HoverContainerElevation,
        disabledElevation: Dp = FilledButtonTokens.DisabledContainerElevation,
    ): ButtonElevation = ButtonElevation(
        defaultElevation = defaultElevation,
        pressedElevation = pressedElevation,
        focusedElevation = focusedElevation,
        hoveredElevation = hoveredElevation,
        disabledElevation = disabledElevation,
    )

    val MinWidth = 64.dp

    val MinHeight = 32.dp
}