package io.github.lumkit.fluent2.ui

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import io.github.lumkit.fluent2.ui.tokens.ShapeKeyTokens
import io.github.lumkit.fluent2.ui.tokens.ShapeTokens

@Immutable
class Shapes(
    val none: CornerBasedShape = ShapeDefaults.None,
    val small: CornerBasedShape = ShapeDefaults.Small,
    val medium: CornerBasedShape = ShapeDefaults.Medium,
    val large: CornerBasedShape = ShapeDefaults.Large,
    val xLarge: CornerBasedShape = ShapeDefaults.XLarge,
    val circular: CornerBasedShape = ShapeDefaults.Circular,
) {
    fun copy(
        none: CornerBasedShape = this.none,
        small: CornerBasedShape = this.small,
        medium: CornerBasedShape = this.medium,
        large: CornerBasedShape = this.large,
        xLarge: CornerBasedShape = this.xLarge,
        circular: CornerBasedShape = this.circular,
    ): Shapes = Shapes(
        none = none,
        small = small,
        medium = medium,
        large = large,
        xLarge = xLarge,
        circular = circular,
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Shapes) return false
        if (none != other.none) return false
        if (small != other.small) return false
        if (medium != other.medium) return false
        if (large != other.large) return false
        if (xLarge != other.xLarge) return false
        if (circular != other.circular) return false
        return true
    }

    override fun hashCode(): Int {
        var result = none.hashCode()
        result = 31 * result + small.hashCode()
        result = 31 * result + medium.hashCode()
        result = 31 * result + large.hashCode()
        result = 31 * result + xLarge.hashCode()
        result = 31 * result + circular.hashCode()
        return result
    }

    override fun toString(): String = buildString {
        append("Shapes(")
        append("none=$none, ")
        append("small=$small, ")
        append("medium=$medium, ")
        append("large=$large, ")
        append("xLarge=$xLarge, ")
        append("circular=$circular, ")
        append(")")
    }
}

object ShapeDefaults {
    val None = ShapeTokens.CornerRadiusNone
    val Small = ShapeTokens.CornerRadiusSmall
    val Medium = ShapeTokens.CornerRadiusMedium
    val Large = ShapeTokens.CornerRadiusLarge
    val XLarge = ShapeTokens.CornerRadiusXLarge
    val Circular =ShapeTokens.CornerRadiusCircular
}


internal fun CornerBasedShape.top(): CornerBasedShape {
    return copy(bottomStart = CornerSize(0.0.dp), bottomEnd = CornerSize(0.0.dp))
}

internal fun CornerBasedShape.bottom(): CornerBasedShape {
    return copy(topStart = CornerSize(0.0.dp), topEnd = CornerSize(0.0.dp))
}

internal fun CornerBasedShape.start(): CornerBasedShape {
    return copy(topEnd = CornerSize(0.0.dp), bottomEnd = CornerSize(0.0.dp))
}

internal fun CornerBasedShape.end(): CornerBasedShape {
    return copy(topStart = CornerSize(0.0.dp), bottomStart = CornerSize(0.0.dp))
}

internal fun Shapes.fromToken(value: ShapeKeyTokens): Shape =
    when (value) {
        ShapeKeyTokens.CornerRadiusNone -> none
        ShapeKeyTokens.CornerRadiusSmall -> small
        ShapeKeyTokens.CornerRadiusMedium -> medium
        ShapeKeyTokens.CornerRadiusLarge -> large
        ShapeKeyTokens.CornerRadiusXLarge -> xLarge
        ShapeKeyTokens.CornerRadiusCircular -> circular
    }

internal val ShapeKeyTokens.value: Shape
    @Composable
    @ReadOnlyComposable
    get() = FluentTheme.shapes.fromToken(this)

internal val LocalShapes = staticCompositionLocalOf { Shapes() }