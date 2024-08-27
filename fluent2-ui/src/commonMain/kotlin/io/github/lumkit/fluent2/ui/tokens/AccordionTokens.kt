package io.github.lumkit.fluent2.ui.tokens

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

internal object AccordionTokens {
    val IconSize = DpSize(20.dp, 20.dp)

    // Item的左边边距（Padding + Spacing + Icon Size）
    val LeadingSpacing = IconSize.width + SpacingTokens.S
}