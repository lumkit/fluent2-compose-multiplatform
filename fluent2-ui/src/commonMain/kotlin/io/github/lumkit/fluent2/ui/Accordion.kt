package io.github.lumkit.fluent2.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.lumkit.fluent2.ui.internal.ProvideContentColorTextStyle
import io.github.lumkit.fluent2.ui.tokens.AccordionTokens
import io.github.lumkit.fluent2.ui.tokens.ShapeTokens
import io.github.lumkit.fluent2.ui.tokens.SpacingTokens
import io.github.lumkit.fluent2.ui.tokens.TypographyTokens

internal val LocalLevelSpacing = compositionLocalOf { 0.dp }

@Composable
fun Accordion(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    leadingIcon: @Composable ((rotate: Float) -> Unit)? = null,
    text: @Composable () -> Unit,
    trailingIcon: @Composable ((rotate: Float) -> Unit)? = null,
    expanded: Boolean,
    contentColor: Color = FluentTheme.colorScheme.onSurface,
    textStyle: TextStyle = TypographyTokens.Body1,
    items: @Composable ColumnScope.(PaddingValues) -> Unit,
) {
    val rotateState by animateFloatAsState(
        targetValue = if (expanded) 90f else 0f,
        label = "rotate",
    )

    val currentSpacing = LocalLevelSpacing.current + AccordionTokens.LeadingSpacing

    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier.clip(ShapeTokens.CornerMedium)
                .fillMaxWidth()
                .clickable(onClick = onClick, enabled = enabled)
        ) {
            Spacer(Modifier.width(currentSpacing))
            Row(
                modifier = Modifier.padding(SpacingTokens.S),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(SpacingTokens.S)
            ) {
                leadingIcon?.let {
                    Surface(
                        modifier = Modifier.size(AccordionTokens.IconSize),
                        color = Color.Transparent,
                    ) {
                        ProvideContentColorTextStyle(
                            contentColor = contentColor,
                            textStyle = textStyle
                        ) {
                            it.invoke(rotateState)
                        }
                    }
                }
                Column(
                    modifier = Modifier.weight(1f),
                ) {
                    ProvideTextStyle(
                        value = textStyle
                    ) {
                        text()
                    }
                }
                trailingIcon?.let {
                    Surface(
                        modifier = Modifier.size(AccordionTokens.IconSize),
                        color = Color.Transparent,
                    ) {
                        ProvideContentColorTextStyle(
                            contentColor = contentColor,
                            textStyle = textStyle
                        ) {
                            it.invoke(rotateState)
                        }
                    }
                }
            }
        }

        AnimatedVisibility(
            visible = expanded,
            label = "expand",
            enter = ExpandTransition.Enter,
            exit = ExpandTransition.Exit,
        ) {
            Item(items, currentSpacing)
        }
    }
}

@Composable
private fun Item(items: @Composable (ColumnScope.(PaddingValues) -> Unit), currentSpacing: Dp) {
    CompositionLocalProvider(
        LocalLevelSpacing provides currentSpacing,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(SpacingTokens.XS)
        ) {
            items(PaddingValues(start = currentSpacing))
        }
    }
}
