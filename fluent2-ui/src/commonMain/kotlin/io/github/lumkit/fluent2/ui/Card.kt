package io.github.lumkit.fluent2.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import io.github.lumkit.fluent2.ui.tokens.ShadowTokens
import io.github.lumkit.fluent2.ui.tokens.ShapeTokens

@Stable
internal fun CardColors.containerColor(enabled: Boolean): Color =
    if (enabled) containerColor else disabledContainerColor

@Stable
internal fun CardColors.contentColor(enabled: Boolean) =
    if (enabled) contentColor else disabledContentColor

@Composable
fun Card(
    modifier: Modifier,
    shape: Shape = ShapeTokens.CornerMedium,
    colors: CardColors = CardDefaults.cardColors(
        containerColor = FluentTheme.colorScheme.surface,
        contentColor = FluentTheme.colorScheme.onSurface,
    ),
    elevation: Dp = ShadowTokens.Shadow4Elevation,
    border: BorderStroke? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    Surface(
        modifier = modifier.shadow(elevation),
        shape = shape,
        color = colors.containerColor(enabled = true),
        contentColor = colors.contentColor(enabled = true),
        border = border,
    ) {
        Column(content = content)
    }
}

@Composable
fun Card(
    modifier: Modifier,
    shape: Shape = ShapeTokens.CornerMedium,
    colors: CardColors = CardDefaults.cardColors(
        containerColor = FluentTheme.colorScheme.surface,
        contentColor = FluentTheme.colorScheme.onSurface,
    ),
    elevation: Dp = ShadowTokens.Shadow4Elevation,
    border: BorderStroke? = null,
    onClick: () -> Unit,
    enabled: Boolean = true,
    content: @Composable ColumnScope.() -> Unit
) {
    Surface(
        modifier = modifier,
        shape = shape,
        color = colors.containerColor(enabled = true),
        contentColor = colors.contentColor(enabled = true),
        border = border,
        onClick = onClick,
        enabled = enabled,
        shadowElevation = elevation,
    ) {
        Column(content = content)
    }
}