package io.github.lumkit.fluent2.ui

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import io.github.lumkit.fluent2.ui.tokens.TypographyKeyTokens
import io.github.lumkit.fluent2.ui.tokens.TypographyTokens

@Immutable
class Typography(
    val caption2: TextStyle = TypographyTokens.Caption2,
    val caption2Strong: TextStyle = TypographyTokens.Caption2Strong,
    val caption1: TextStyle = TypographyTokens.Caption1,
    val caption1Strong: TextStyle = TypographyTokens.Caption1Strong,
    val caption1Stronger: TextStyle = TypographyTokens.Caption1Stronger,
    val body1: TextStyle = TypographyTokens.Body1,
    val body1Strong: TextStyle = TypographyTokens.Body1Strong,
    val body1Stronger: TextStyle = TypographyTokens.Body1Stronger,
    val body2: TextStyle = TypographyTokens.Body2,
    val subtitle2: TextStyle = TypographyTokens.Subtitle2,
    val subtitle2Stronger: TextStyle = TypographyTokens.Subtitle2Stronger,
    val subtitle1: TextStyle = TypographyTokens.Subtitle1,
    val title3: TextStyle = TypographyTokens.Title3,
    val title2: TextStyle = TypographyTokens.Title2,
    val title1: TextStyle = TypographyTokens.Title1,
    val largeTitle: TextStyle = TypographyTokens.LargeTitle,
    val display: TextStyle = TypographyTokens.Display,
) {

    fun copy(
        caption2: TextStyle = this.caption2,
        caption2Strong: TextStyle = this.caption2Strong,
        caption1: TextStyle = this.caption1,
        caption1Strong: TextStyle = this.caption1Strong,
        caption1Stronger: TextStyle = this.caption1Stronger,
        body1: TextStyle = this.body1,
        body1Strong: TextStyle = this.body1Strong,
        body1Stronger: TextStyle = this.body1Stronger,
        body2: TextStyle = this.body2,
        subtitle2: TextStyle = this.subtitle2,
        subtitle2Stronger: TextStyle = this.subtitle2Stronger,
        subtitle1: TextStyle = this.subtitle1,
        title3: TextStyle = this.title3,
        title2: TextStyle = this.title2,
        title1: TextStyle = this.title1,
        largeTitle: TextStyle = this.largeTitle,
        display: TextStyle = this.display,
    ): Typography =
        Typography(
            caption2 = caption2,
            caption2Strong = caption2Strong,
            caption1 = caption1,
            caption1Strong = caption1Strong,
            caption1Stronger = caption1Stronger,
            body1 = body1,
            body1Strong = body1Strong,
            body1Stronger = body1Stronger,
            body2 = body2,
            subtitle2 = subtitle2,
            subtitle2Stronger = subtitle2Stronger,
            subtitle1 = subtitle1,
            title3 = title3,
            title2 = title2,
            title1 = title1,
            largeTitle = largeTitle,
            display = display,
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Typography) return false
        if (caption2 != other.caption2) return false
        if (caption2Strong != other.caption2Strong) return false
        if (caption1 != other.caption1) return false
        if (caption1Strong != other.caption1Strong) return false
        if (caption1Stronger != other.caption1Stronger) return false
        if (body1 != other.body1) return false
        if (body1Strong != other.body1Strong) return false
        if (body1Stronger != other.body1Stronger) return false
        if (body2 != other.body2) return false
        if (subtitle2 != other.subtitle2) return false
        if (subtitle2Stronger != other.subtitle2Stronger) return false
        if (subtitle1 != other.subtitle1) return false
        if (title3 != other.title3) return false
        if (title2 != other.title2) return false
        if (title1 != other.title1) return false
        if (largeTitle != other.largeTitle) return false
        if (display != other.display) return false
        return true
    }

    override fun hashCode(): Int {
        var result = caption2.hashCode()
        result = 31 * result + caption2Strong.hashCode()
        result = 31 * result + caption1.hashCode()
        result = 31 * result + caption1Strong.hashCode()
        result = 31 * result + caption1Stronger.hashCode()
        result = 31 * result + body1.hashCode()
        result = 31 * result + body1Strong.hashCode()
        result = 31 * result + body1Stronger.hashCode()
        result = 31 * result + body2.hashCode()
        result = 31 * result + subtitle2.hashCode()
        result = 31 * result + subtitle2Stronger.hashCode()
        result = 31 * result + subtitle1.hashCode()
        result = 31 * result + title3.hashCode()
        result = 31 * result + title2.hashCode()
        result = 31 * result + title1.hashCode()
        result = 31 * result + largeTitle.hashCode()
        result = 31 * result + display.hashCode()
        return result
    }

    override fun toString(): String = buildString {
        append("Typography(")
        append("caption2=$caption2, ")
        append("caption2Strong=$caption2Strong, ")
        append("caption1=$caption1, ")
        append("caption1Strong=$caption1Strong, ")
        append("caption1Stronger=$caption1Stronger, ")
        append("body1=$body1, ")
        append("body1Strong=$body1Strong, ")
        append("body1Stronger=$body1Stronger, ")
        append("body2=$body2, ")
        append("subtitle2=$subtitle2, ")
        append("subtitle2Stronger=$subtitle2Stronger, ")
        append("subtitle1=$subtitle1, ")
        append("title3=$title3, ")
        append("title2=$title2, ")
        append("title1=$title1, ")
        append("largeTitle=$largeTitle, ")
        append("display=$display")
        append(")")
    }
}

internal fun Typography.fromToken(value: TypographyKeyTokens): TextStyle =
    when (value) {
        TypographyKeyTokens.Caption2 -> caption2
        TypographyKeyTokens.Caption2Strong -> caption2Strong
        TypographyKeyTokens.Caption1 ->caption1
        TypographyKeyTokens.Caption1Strong -> caption1Strong
        TypographyKeyTokens.Caption1Stronger -> caption1Stronger
        TypographyKeyTokens.Body1 -> body1
        TypographyKeyTokens.Body1Strong -> body1Strong
        TypographyKeyTokens.Body1Stronger -> body1Stronger
        TypographyKeyTokens.Body2 -> body2
        TypographyKeyTokens.Subtitle2 -> subtitle2
        TypographyKeyTokens.Subtitle2Stronger -> subtitle2Stronger
        TypographyKeyTokens.Subtitle1 -> subtitle1
        TypographyKeyTokens.Title3 -> title3
        TypographyKeyTokens.Title2 -> title2
        TypographyKeyTokens.Title1 -> title1
        TypographyKeyTokens.LargeTitle -> largeTitle
        TypographyKeyTokens.Display -> display
    }

internal val LocalTypography = staticCompositionLocalOf { Typography() }