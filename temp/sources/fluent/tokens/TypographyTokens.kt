package io.github.lumkit.fluent2.ui.tokens

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineHeightStyle

internal object TypographyTokens {
    val Caption2 = DefaultTextStyle.copy(
        fontFamily = FontFamilyTokens.FamilyBase,
        fontSize = FontSizeTokens.Base100,
        fontWeight = FontWeightTokens.Regular,
        lineHeight = LineHeightTokens.Base100,
    )

    val Caption2Strong = DefaultTextStyle.copy(
        fontFamily = FontFamilyTokens.FamilyBase,
        fontSize = FontSizeTokens.Base100,
        fontWeight = FontWeightTokens.Semibold,
        lineHeight = LineHeightTokens.Base100,
    )

    val Caption1 = DefaultTextStyle.copy(
        fontFamily = FontFamilyTokens.FamilyBase,
        fontSize = FontSizeTokens.Base200,
        fontWeight = FontWeightTokens.Regular,
        lineHeight = LineHeightTokens.Base200,
    )

    val Caption1Strong = DefaultTextStyle.copy(
        fontFamily = FontFamilyTokens.FamilyBase,
        fontSize = FontSizeTokens.Base200,
        fontWeight = FontWeightTokens.Semibold,
        lineHeight = LineHeightTokens.Base200,
    )

    val Caption1Stronger = DefaultTextStyle.copy(
        fontFamily = FontFamilyTokens.FamilyBase,
        fontSize = FontSizeTokens.Base200,
        fontWeight = FontWeightTokens.Bold,
        lineHeight = LineHeightTokens.Base200,
    )

    val Body1 = DefaultTextStyle.copy(
        fontFamily = FontFamilyTokens.FamilyBase,
        fontSize = FontSizeTokens.Base300,
        fontWeight = FontWeightTokens.Regular,
        lineHeight = LineHeightTokens.Base300,
    )

    val Body1Strong = DefaultTextStyle.copy(
        fontFamily = FontFamilyTokens.FamilyBase,
        fontSize = FontSizeTokens.Base300,
        fontWeight = FontWeightTokens.Semibold,
        lineHeight = LineHeightTokens.Base300,
    )

    val Body1Stronger = DefaultTextStyle.copy(
        fontFamily = FontFamilyTokens.FamilyBase,
        fontSize = FontSizeTokens.Base300,
        fontWeight = FontWeightTokens.Bold,
        lineHeight = LineHeightTokens.Base300,
    )

    val Body2 = DefaultTextStyle.copy(
        fontFamily = FontFamilyTokens.FamilyBase,
        fontSize = FontSizeTokens.Base400,
        fontWeight = FontWeightTokens.Regular,
        lineHeight = LineHeightTokens.Base400,
    )

    val Subtitle2 = DefaultTextStyle.copy(
        fontFamily = FontFamilyTokens.FamilyBase,
        fontSize = FontSizeTokens.Base400,
        fontWeight = FontWeightTokens.Semibold,
        lineHeight = LineHeightTokens.Base400,
    )

    val Subtitle2Stronger = DefaultTextStyle.copy(
        fontFamily = FontFamilyTokens.FamilyBase,
        fontSize = FontSizeTokens.Base400,
        fontWeight = FontWeightTokens.Bold,
        lineHeight = LineHeightTokens.Base400,
    )

    val Subtitle1 = DefaultTextStyle.copy(
        fontFamily = FontFamilyTokens.FamilyBase,
        fontSize = FontSizeTokens.Base500,
        fontWeight = FontWeightTokens.Bold,
        lineHeight = LineHeightTokens.Base500,
    )

    val Title3 = DefaultTextStyle.copy(
        fontFamily = FontFamilyTokens.FamilyBase,
        fontSize = FontSizeTokens.Base600,
        fontWeight = FontWeightTokens.Semibold,
        lineHeight = LineHeightTokens.Base600,
    )

    val Title2 = DefaultTextStyle.copy(
        fontFamily = FontFamilyTokens.FamilyBase,
        fontSize = FontSizeTokens.Hero700,
        fontWeight = FontWeightTokens.Semibold,
        lineHeight = LineHeightTokens.Hero700,
    )

    val Title1 = DefaultTextStyle.copy(
        fontFamily = FontFamilyTokens.FamilyBase,
        fontSize = FontSizeTokens.Hero800,
        fontWeight = FontWeightTokens.Semibold,
        lineHeight = LineHeightTokens.Hero800,
    )

    val LargeTitle = DefaultTextStyle.copy(
        fontFamily = FontFamilyTokens.FamilyBase,
        fontSize = FontSizeTokens.Hero900,
        fontWeight = FontWeightTokens.Semibold,
        lineHeight = LineHeightTokens.Hero900,
    )

    val Display = DefaultTextStyle.copy(
        fontFamily = FontFamilyTokens.FamilyBase,
        fontSize = FontSizeTokens.Hero1000,
        fontWeight = FontWeightTokens.Semibold,
        lineHeight = LineHeightTokens.Hero1000,
    )
}

internal val DefaultLineHeightStyle = LineHeightStyle(
    alignment = LineHeightStyle.Alignment.Center,
    trim = LineHeightStyle.Trim.None
)

internal val DefaultTextStyle = TextStyle.Default.copy(
    lineHeightStyle = DefaultLineHeightStyle,
)