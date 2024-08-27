package io.github.lumkit.fluent2

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import fluent2_compose_multiplatform.simple.generated.resources.Res
import fluent2_compose_multiplatform.simple.generated.resources.compose_multiplatform
import fluent2_compose_multiplatform.simple.generated.resources.ic_chevron_right
import io.github.lumkit.fluent2.ui.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.random.Random

@Composable
@Preview
fun App() {
    var isDark by remember { mutableStateOf(false) }
    FluentTheme(
        colorScheme = if (isDark) darkScheme else lightScheme,
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = FluentTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
                    .padding(28.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Button(onClick = { isDark = !isDark }) {
                    Text(if (isDark) "Dark" else "Light")
                }

                var expanded by remember { mutableStateOf(true) }
                Accordion(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        expanded = !expanded
                    },
                    expanded = expanded,
                    leadingIcon = {
                        Icon(
                            painter = painterResource(Res.drawable.ic_chevron_right),
                            contentDescription = null,
                            modifier = Modifier.rotate(it)
                        )
                    },
                    text = {
                        Text("Accordion")
                    }
                ) {
                    AccordionTest()
                    AccordionTest()
                    AccordionTest()
                    AccordionTest()
                }

                Card(
                    modifier = Modifier.size(100.dp, 36.dp),
                    onClick = {

                    }
                ) {
                    Text("Card")
                }
            }
        }
    }
}

@Composable
private fun AccordionTest(hasChildren: Boolean = true) {
    var expand by rememberSaveable { mutableStateOf(false) }

    Accordion(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            expand = !expand
        },
        expanded = expand,
        leadingIcon = {
            Icon(
                painter = if (hasChildren) painterResource(Res.drawable.ic_chevron_right) else painterResource(Res.drawable.compose_multiplatform),
                contentDescription = null,
                modifier = Modifier.rotate(it)
            )
        },
        text = {
            Text("Accordion")
        },
        trailingIcon = {
            Icon(
                painter = if (hasChildren) painterResource(Res.drawable.ic_chevron_right) else painterResource(Res.drawable.compose_multiplatform),
                contentDescription = null,
                modifier = Modifier.rotate(it)
            )
        }
    ) {
        if (hasChildren) {
            AccordionTest(Random.nextBoolean())
        }
    }
}