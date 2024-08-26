package io.github.lumkit.fluent2.ui

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.lumkit.fluent2.ui.tokens.ColorDarkTokens
import io.github.lumkit.fluent2.ui.tokens.ColorLightTokens
import io.github.lumkit.fluent2.ui.tokens.ColorSchemeKeyTokens
import kotlin.math.ln

@Immutable
class ColorScheme(
    val accent: Color,
    val onAccent: Color,
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onSurface: Color,
    val outline: Color,
    val error: Color,
    val info: Color,
    val success: Color,
    val warning: Color,
    val neutrals: Color,
) {

    fun copy(
        accent: Color = this.accent,
        onAccent: Color = this.onAccent,
        background: Color = this.background,
        onBackground: Color = this.onBackground,
        surface: Color = this.surface,
        onSurface: Color = this.onSurface,
        outline: Color = this.outline,
        error: Color = this.error,
        info: Color = this.info,
        success: Color = this.success,
        warning: Color = this.warning,
        neutrals: Color = this.neutrals,
    ): ColorScheme = ColorScheme(
        accent = accent,
        onAccent = onAccent,
        background = background,
        onBackground = onBackground,
        surface = surface,
        onSurface = onSurface,
        outline = outline,
        error = error,
        info = info,
        success = success,
        warning = warning,
        neutrals = neutrals,
    )

    override fun toString(): String = buildString {
        append("ColorScheme(")
        append("accent=$accent, ")
        append("onAccent=$onAccent, ")
        append("background=$background, ")
        append("onBackground=$onBackground, ")
        append("surface=$surface, ")
        append("onSurface=$onSurface, ")
        append("outline=$outline, ")
        append("error=$error, ")
        append("info=$info, ")
        append("success=$success, ")
        append("warning=$warning, ")
        append("neutrals=$neutrals, ")
        append(")")
    }

    // TODO 实现组件颜色缓存
    internal var defaultButtonColorsCached: ButtonColors? = null
}

/**
 * 返回一个Fluent2的浅色方案
 */
fun lightColorScheme(
    accent: Color = ColorLightTokens.BrandBackground,
    onAccent: Color = ColorLightTokens.NeutralBackground1,
    background: Color = ColorLightTokens.NeutralBackground3,
    onBackground: Color = ColorLightTokens.NeutralForeground2,
    surface: Color = ColorLightTokens.NeutralBackground1,
    onSurface: Color = ColorLightTokens.NeutralForeground2,
    outline: Color = ColorLightTokens.NeutralForeground4,
    error: Color = ColorLightTokens.PaletteBerryBorder2,
    info: Color = ColorLightTokens.PaletteBlueBorderActive,
    success: Color = ColorLightTokens.PaletteLightGreenBorder2,
    warning: Color = ColorLightTokens.PaletteMarigoldBorder2,
    neutrals: Color = ColorLightTokens.NeutralBackground1,
): ColorScheme =
    ColorScheme(
        accent = accent,
        onAccent = onAccent,
        background = background,
        onBackground = onBackground,
        surface = surface,
        onSurface = onSurface,
        outline = outline,
        error = error,
        info = info,
        success = success,
        warning = warning,
        neutrals = neutrals,
    )

/**
 * 返回一个Fluent2的深色方案
 */
fun darkColorScheme(
    accent: Color = ColorDarkTokens.BrandBackground,
    onAccent: Color = ColorDarkTokens.NeutralForeground2,
    background: Color = ColorDarkTokens.NeutralBackground3,
    onBackground: Color = ColorDarkTokens.NeutralForeground2,
    surface: Color = ColorDarkTokens.NeutralBackground1,
    onSurface: Color = ColorDarkTokens.NeutralForeground2,
    outline: Color = ColorDarkTokens.NeutralForeground4,
    error: Color = ColorDarkTokens.PaletteBerryBorder2,
    info: Color = ColorDarkTokens.PaletteBlueBorderActive,
    success: Color = ColorDarkTokens.PaletteLightGreenBorder2,
    warning: Color = ColorDarkTokens.PaletteMarigoldBorder2,
    neutrals: Color = ColorDarkTokens.NeutralBackground1,
): ColorScheme =
    ColorScheme(
        accent = accent,
        onAccent = onAccent,
        background = background,
        onBackground = onBackground,
        surface = surface,
        onSurface = onSurface,
        outline = outline,
        error = error,
        info = info,
        success = success,
        warning = warning,
        neutrals = neutrals,
    )

/**
 * Fluent颜色系统包含通常用于组件内的背景和内容颜色的颜色对，
 * 例如，一个[Button]以包含`Background`的颜色作为背景，则以包含`Foreground`的颜色作为容器颜色（一般是文本或图标）。
 *
 * 此函数尝试将提供的[backgroundColor]与这个[ColorScheme]中包含`Background`的颜色匹配，然后返回用于内容相应的颜色。
 * 例如，当[backgroundColor]为[ColorScheme.neutralBackground1]时，将返回[ColorScheme.neutralForeground1]
 *
 * @return 与[backgroundColor]匹配的内容颜色。如果[backgroundColor]不存在于主题的[ColorScheme]中，
 * 则返回[Color.Unspecified]
 */
@Stable
fun ColorScheme.contentColorFor(backgroundColor: Color): Color =
    when (backgroundColor) {
        accent -> onAccent
        background -> onBackground
        surface -> onSurface
        else -> Color.Unspecified
    }

@Composable
@ReadOnlyComposable
fun contentColorFor(backgroundColor: Color) =
    FluentTheme.colorScheme.contentColorFor(backgroundColor).takeOrElse {
        LocalContentColor.current
    }

@Stable
fun ColorScheme.surfaceColorAtElevation(
    elevation: Dp,
): Color {
    if (elevation == 0.dp) return surface
    val alpha = ((4.5f * ln(elevation.value + 1)) + 2f) / 100f
    return onSurface.copy(alpha = alpha).compositeOver(surface)
}

@Composable
@ReadOnlyComposable
internal fun ColorScheme.applyTonalElevation(backgroundColor: Color, elevation: Dp): Color {
    val tonalElevationEnabled = LocalTonalElevationEnabled.current
    return if (backgroundColor == surface && tonalElevationEnabled) {
        surfaceColorAtElevation(elevation)
    } else {
        backgroundColor
    }
}

val LocalTonalElevationEnabled = staticCompositionLocalOf { true }

/**
 * 组件颜色编辑的辅助函数。
 */
@Stable
internal fun ColorScheme.fromToken(value: ColorSchemeKeyTokens): Color =
    when (value) {
        ColorSchemeKeyTokens.Accent -> accent
        ColorSchemeKeyTokens.OnAccent -> onAccent
        ColorSchemeKeyTokens.Background -> background
        ColorSchemeKeyTokens.OnBackground -> onBackground
        ColorSchemeKeyTokens.Surface -> surface
        ColorSchemeKeyTokens.OnSurface -> onSurface
        ColorSchemeKeyTokens.Outline -> outline
        ColorSchemeKeyTokens.Error -> error
        ColorSchemeKeyTokens.Info -> info
        ColorSchemeKeyTokens.Success -> success
        ColorSchemeKeyTokens.Warning -> warning
        ColorSchemeKeyTokens.Neutrals -> neutrals
    }

internal val LocalColorScheme = staticCompositionLocalOf { lightColorScheme() }

internal const val DisabledAlpha = 0.38f