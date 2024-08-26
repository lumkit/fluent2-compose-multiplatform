package io.github.lumkit.fluent2.ui.tokens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.unit.dp

internal object ButtonTokens {
    val ButtonShape = ShapeTokens.CornerMedium

    private val ButtonHorizontalSmallPadding = 12.dp
    private val ButtonVerticalSmallPadding = 4.dp

    private val ButtonHorizontalMediumPadding = 16.dp
    private val ButtonVerticalMediumPadding = 8.dp

    private val ButtonHorizontalLargePadding = 24.dp
    private val ButtonVerticalLargePadding = 12.dp

    val ContentSmallPadding =
        PaddingValues(
            start = ButtonHorizontalSmallPadding,
            top = ButtonVerticalSmallPadding,
            end = ButtonHorizontalSmallPadding,
            bottom = ButtonVerticalSmallPadding
        )

    val ContentMediumPadding =
        PaddingValues(
            start = ButtonHorizontalMediumPadding,
            top = ButtonVerticalMediumPadding,
            end = ButtonHorizontalMediumPadding,
            bottom = ButtonVerticalMediumPadding
        )

    val ContentLargePadding =
        PaddingValues(
            start = ButtonHorizontalLargePadding,
            top = ButtonVerticalLargePadding,
            end = ButtonHorizontalLargePadding,
            bottom = ButtonVerticalLargePadding
        )

    val ContentSmallSpacing = SpacingTokens.S
    val ContentMediumSpacing = SpacingTokens.M
    val ContentLargeSpacing = SpacingTokens.L


    val MinWidth = 64.dp
    val MinHeight = 32.dp

    val Stroke: BorderStroke
        @Composable
        @ReadOnlyComposable
        get() = BorderStroke(
            StrokeTokens.Thin,
            MaterialTheme.colorScheme.outline.copy(.38f)
        )
}