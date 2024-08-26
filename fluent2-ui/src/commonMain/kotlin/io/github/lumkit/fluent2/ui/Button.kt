package io.github.lumkit.fluent2.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.util.fastForEach
import io.github.lumkit.fluent2.ui.tokens.ButtonTokens
import io.github.lumkit.fluent2.ui.tokens.TypographyTokens
import io.github.lumkit.fluent2.ui.tokens.outlineLight

@Composable
fun Button(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ButtonTokens.ButtonShape,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        contentColor = Color.White,
    ),
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonTokens.ContentSmallPadding,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable RowScope.() -> Unit
) {
    androidx.compose.material3.Button(
        onClick,
        modifier.then(
            Modifier.defaultMinSize(
                minWidth = ButtonTokens.MinWidth,
                minHeight = ButtonTokens.MinHeight
            )
        ),
        enabled,
        shape,
        colors,
        elevation,
        border,
        contentPadding,
        interactionSource,
    ) {
        ProvideTextStyle(
            value = TypographyTokens.Caption1
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(
                    ButtonTokens.ContentSmallSpacing,
                    Alignment.CenterHorizontally
                ),
            ) {
                content()
            }
        }
    }
}

@Composable
fun DefaultButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ButtonTokens.ButtonShape,
    colors: ButtonColors = ButtonDefaults.buttonColors().copy(
        contentColor = FluentTheme.colorScheme.onSurface,
        containerColor = FluentTheme.colorScheme.surface,
    ),
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: BorderStroke? = ButtonTokens.Stroke,
    contentPadding: PaddingValues = ButtonTokens.ContentSmallPadding,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick,
        modifier,
        enabled,
        shape,
        colors,
        elevation,
        border,
        contentPadding,
        interactionSource,
        content
    )
}

@Composable
fun OutlineButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ButtonTokens.ButtonShape,
    colors: ButtonColors = ButtonDefaults.buttonColors().copy(
        contentColor = FluentTheme.colorScheme.onSurface,
        containerColor = FluentTheme.colorScheme.background,
    ),
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: BorderStroke? = ButtonTokens.Stroke,
    contentPadding: PaddingValues = ButtonTokens.ContentSmallPadding,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick,
        modifier,
        enabled,
        shape,
        colors,
        elevation,
        border,
        contentPadding,
        interactionSource,
        content
    )
}

@Composable
fun SubtleButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ButtonTokens.ButtonShape,
    colors: ButtonColors = ButtonDefaults.buttonColors().copy(
        contentColor = FluentTheme.colorScheme.onSurface,
        containerColor = Color.Transparent,
    ),
    elevation: ButtonElevation? = null,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonTokens.ContentSmallPadding,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable RowScope.() -> Unit
) {
    var isHovered by remember { mutableStateOf(false) }

    val enterColor = FluentTheme.colorScheme.primary
    val exitColor = colors.contentColor

    Button(
        onClick,
        modifier.pointerInput(Unit) {
            awaitPointerEventScope {
                while (true) {
                    val event = awaitPointerEvent()
                    when (event.type) {
                        PointerEventType.Enter -> {
                            isHovered = true
                        }

                        PointerEventType.Exit -> {
                            isHovered = false
                        }
                    }
                }
            }
        },
        enabled,
        shape,
        colors,
        elevation,
        border,
        contentPadding,
        interactionSource,
    ) {
        CompositionLocalProvider(
            LocalIconColor provides if (isHovered) enterColor else exitColor,
        ) {
            content()
        }
    }
}

val LocalIconColor = staticCompositionLocalOf { outlineLight }

@Composable
fun TransparentButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ButtonTokens.ButtonShape,
    colors: ButtonColors = ButtonDefaults.buttonColors().copy(
        contentColor = FluentTheme.colorScheme.onSurface,
        containerColor = Color.Transparent,
    ),
    elevation: ButtonElevation? = null,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonTokens.ContentSmallPadding,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable RowScope.() -> Unit
) {
    var isHovered by remember { mutableStateOf(false) }

    val enterColor = FluentTheme.colorScheme.primary
    val exitColor = colors.contentColor

    Button(
        onClick,
        modifier.pointerInput(Unit) {
            awaitPointerEventScope {
                while (true) {
                    val event = awaitPointerEvent()
                    when (event.type) {
                        PointerEventType.Enter -> {
                            isHovered = true
                        }

                        PointerEventType.Exit -> {
                            isHovered = false
                        }
                    }
                }
            }
        },
        enabled,
        shape,
        colors.copy(
            contentColor = if (isHovered) enterColor else exitColor,
        ),
        elevation,
        border,
        contentPadding,
        interactionSource,
        content,
    )
}