package io.github.lumkit.fluent2.ui

import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically

object ExpandTransition {
    val Enter = expandVertically()
    val Exit = shrinkVertically()
}