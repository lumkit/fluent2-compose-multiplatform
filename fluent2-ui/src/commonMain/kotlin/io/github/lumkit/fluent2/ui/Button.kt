package io.github.lumkit.fluent2.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.lumkit.fluent2.ui.internal.ProvideContentColorTextStyle
import io.github.lumkit.fluent2.ui.tokens.ButtonTokens
import io.github.lumkit.fluent2.ui.tokens.TypographyTokens
import io.github.lumkit.fluent2.ui.tokens.outlineLight

@Stable
internal fun ButtonColors.containerColor(enabled: Boolean): Color =
    if (enabled) containerColor else disabledContainerColor

@Stable
internal fun ButtonColors.contentColor(enabled: Boolean): Color =
    if (enabled) contentColor else disabledContentColor

@Composable
fun Button(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ButtonTokens.ButtonShape,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        contentColor = Color.White,
    ),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonTokens.ContentMediumPadding,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable RowScope.() -> Unit
) {
    @Suppress("NAME_SHADOWING")
    val interactionSource = interactionSource ?: remember { MutableInteractionSource() }
    val containerColor = colors.containerColor(enabled)
    val contentColor = colors.contentColor(enabled)

    Surface(
        modifier = modifier.clip(shape)
            .semantics { role = Role.Button }
            .clickable(
                enabled = enabled,
                interactionSource = interactionSource,
                indication = ripple(true, Dp.Unspecified, Color.Unspecified),
                role = Role.Button,
                onClick = onClick,
            ),
        shape = shape,
        color = containerColor,
        contentColor = contentColor,
        shadowElevation = 0.dp,
        border = border,
    ) {
        ProvideContentColorTextStyle(
            contentColor = contentColor,
            textStyle = TypographyTokens.Caption1Strong
        ) {
            Row(
                Modifier.defaultMinSize(
                    minWidth = ButtonTokens.MinWidth,
                    minHeight = ButtonTokens.MinHeight
                ).padding(contentPadding),
                horizontalArrangement = Arrangement.spacedBy(
                    ButtonTokens.ContentSmallSpacing,
                    Alignment.CenterHorizontally
                ),
                verticalAlignment = Alignment.CenterVertically,
                content = content,
            )
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
    border: BorderStroke? = ButtonTokens.Stroke,
    contentPadding: PaddingValues = ButtonTokens.ContentMediumPadding,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable RowScope.() -> Unit
) {
    @Suppress("NAME_SHADOWING")
    val interactionSource = interactionSource ?: remember { MutableInteractionSource() }
    val containerColor = colors.containerColor(enabled)
    val contentColor = colors.contentColor(enabled)

    Surface(
        modifier = modifier.clip(shape)
            .semantics { role = Role.Button }
            .clickable(
                enabled = enabled,
                interactionSource = interactionSource,
                indication = ripple(true, Dp.Unspecified, Color.Unspecified),
                role = Role.Button,
                onClick = onClick,
            ),
        shape = shape,
        color = containerColor,
        contentColor = contentColor,
        shadowElevation = 0.dp,
        border = border,
    ) {
        ProvideContentColorTextStyle(
            contentColor = contentColor,
            textStyle = TypographyTokens.Caption1Strong
        ) {
            Row(
                Modifier.defaultMinSize(
                    minWidth = ButtonTokens.MinWidth,
                    minHeight = ButtonTokens.MinHeight
                ).padding(contentPadding),
                horizontalArrangement = Arrangement.spacedBy(
                    ButtonTokens.ContentSmallSpacing,
                    Alignment.CenterHorizontally
                ),
                verticalAlignment = Alignment.CenterVertically,
                content = content,
            )
        }
    }
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
    border: BorderStroke? = ButtonTokens.Stroke,
    contentPadding: PaddingValues = ButtonTokens.ContentMediumPadding,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable RowScope.() -> Unit
) {
    @Suppress("NAME_SHADOWING")
    val interactionSource = interactionSource ?: remember { MutableInteractionSource() }
    val containerColor = colors.containerColor(enabled)
    val contentColor = colors.contentColor(enabled)

    Surface(
        modifier = modifier.clip(shape)
            .semantics { role = Role.Button }
            .clickable(
                enabled = enabled,
                interactionSource = interactionSource,
                indication = ripple(true, Dp.Unspecified, Color(0x11EEEEEE)),
                role = Role.Button,
                onClick = onClick,
            ),
        shape = shape,
        color = containerColor,
        contentColor = contentColor,
        shadowElevation = 0.dp,
        border = border,
    ) {
        ProvideContentColorTextStyle(
            contentColor = contentColor,
            textStyle = TypographyTokens.Caption1Strong
        ) {
            Row(
                Modifier.defaultMinSize(
                    minWidth = ButtonTokens.MinWidth,
                    minHeight = ButtonTokens.MinHeight
                ).padding(contentPadding),
                horizontalArrangement = Arrangement.spacedBy(
                    ButtonTokens.ContentSmallSpacing,
                    Alignment.CenterHorizontally
                ),
                verticalAlignment = Alignment.CenterVertically,
                content = content,
            )
        }
    }
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
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonTokens.ContentMediumPadding,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable RowScope.() -> Unit
) {
    @Suppress("NAME_SHADOWING")
    val interactionSource = interactionSource ?: remember { MutableInteractionSource() }
    val containerColor = colors.containerColor(enabled)
    val contentColor = colors.contentColor(enabled)

    var isHover by remember { mutableStateOf(false) }

    Surface(
        modifier = modifier.clip(shape)
            .semantics { role = Role.Button }
            .clickable(
                enabled = enabled,
                interactionSource = interactionSource,
                indication = ripple(true, Dp.Unspecified, Color.Unspecified),
                role = Role.Button,
                onClick = onClick,
            )
            .pointerInput(Unit) {
                awaitPointerEventScope {
                    while (true) {
                        val event = awaitPointerEvent()
                        when (event.type) {
                            PointerEventType.Enter -> {
                                isHover = true
                            }
                            PointerEventType.Exit -> {
                                isHover = false
                            }
                        }
                    }
                }
            },
        shape = shape,
        color = containerColor,
        contentColor = contentColor,
        shadowElevation = 0.dp,
        border = border,
    ) {
        ProvideContentColorTextStyle(
            contentColor = contentColor,
            textStyle = TypographyTokens.Caption1Strong
        ) {
            // 高亮图标颜色
            CompositionLocalProvider(
                LocalIconColor provides if (isHover) FluentTheme.colorScheme.primary else contentColor,
            ) {
                Row(
                    Modifier.defaultMinSize(
                        minWidth = ButtonTokens.MinWidth,
                        minHeight = ButtonTokens.MinHeight
                    ).padding(contentPadding),
                    horizontalArrangement = Arrangement.spacedBy(
                        ButtonTokens.ContentSmallSpacing,
                        Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                    content = content,
                )
            }
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
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonTokens.ContentMediumPadding,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable RowScope.() -> Unit
) {
    @Suppress("NAME_SHADOWING")
    val interactionSource = interactionSource ?: remember { MutableInteractionSource() }
    val containerColor = colors.containerColor(enabled)
    val contentColor = colors.contentColor(enabled)

    var isHover by remember { mutableStateOf(false) }

    Surface(
        modifier = modifier.clip(shape)
            .semantics { role = Role.Button }
            .clickable(
                enabled = enabled,
                interactionSource = interactionSource,
                indication = null,
                role = Role.Button,
                onClick = onClick,
            )
            .pointerInput(Unit) {
                awaitPointerEventScope {
                    while (true) {
                        val event = awaitPointerEvent()
                        when (event.type) {
                            PointerEventType.Enter -> {
                                isHover = true
                            }
                            PointerEventType.Exit -> {
                                isHover = false
                            }
                        }
                    }
                }
            },
        shape = shape,
        color = containerColor,
        contentColor = contentColor,
        shadowElevation = 0.dp,
        border = border,
    ) {
        ProvideContentColorTextStyle(
            contentColor = if (isHover) FluentTheme.colorScheme.primary else contentColor,
            textStyle = TypographyTokens.Caption1Strong
        ) {
            Row(
                Modifier.defaultMinSize(
                    minWidth = ButtonTokens.MinWidth,
                    minHeight = ButtonTokens.MinHeight
                ).padding(contentPadding),
                horizontalArrangement = Arrangement.spacedBy(
                    ButtonTokens.ContentSmallSpacing,
                    Alignment.CenterHorizontally
                ),
                verticalAlignment = Alignment.CenterVertically,
                content = content,
            )
        }
    }
}