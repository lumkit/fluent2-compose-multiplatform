package io.github.lumkit.fluent2.ui

import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember

/**
 * 包含用于访问在层次结构中调用站点未知提供的当前主题值的函数
 */
object FluentTheme {

    val colorScheme: ColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalColorScheme.current

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val shapes: Shapes
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current
}

/**
 * `FluentTheme`可以统一Fluent2组件的样式，以更好地展示你的设计风格
 *
 * Fluent2组件（比如Button和CheckBox）在检索默认值时使用该函数提供的值
 *
 * 你可以为该组件提供[ColorScheme]、[Typography]属性来设置所有值。使用它来配置这个FluentTheme中的元素的整体主题。
 *
 * 任何未设置的值都将集成FluentTheme的当前值，如果没有父级FluentTheme，则返回默认值。
 * 这允许在应用程序的根组合域使用一个FluentTheme，然后为你的UI的不同页面、组件分离FluentTheme，支付给需要更改的主题定义部分
 *
 * @param colorScheme 该重组域的Fluent Color主题的完整定义
 * @param shapes 一组被作用于此重组域的形状系统
 * @param typography 一组被作用于此重组域的文本样式系统
 *
 */
@Suppress("DEPRECATION_ERROR")
@Composable
fun FluentTheme(
    colorScheme: ColorScheme = FluentTheme.colorScheme,
    shapes: Shapes = FluentTheme.shapes,
    typography: Typography = FluentTheme.typography,
    content: @Composable () -> Unit
) {
    val selectionColors = rememberTextSelectionColors(colorScheme)
    CompositionLocalProvider(
        LocalColorScheme provides colorScheme,
        LocalShapes provides shapes,
        LocalTextSelectionColors provides selectionColors,
        LocalTypography provides typography,
    ) {
        ProvideTextStyle(value = typography.body1, content = content)
    }
}

@Composable
internal fun rememberTextSelectionColors(colorScheme: ColorScheme): TextSelectionColors {
    val primaryColor = colorScheme.accent
    return remember(primaryColor) {
        TextSelectionColors(
            handleColor = primaryColor,
            backgroundColor = primaryColor.copy(alpha = TextSelectionBackgroundOpacity),
        )
    }
}

internal const val TextSelectionBackgroundOpacity = 0.4f