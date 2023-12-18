package com.shagalalab.lucide.voyagertest

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

object TabOne : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val icon = painterResource(androidx.core.R.drawable.ic_call_answer)

            return remember {
                TabOptions(
                    index = 0u,
                    title = "One",
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        Navigator(ScreenOne)
    }
}

object ScreenOne : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Button(
                onClick = {
                    navigator.printTree("Before pushing auth screen")
                    navigator.parent?.parent?.push(AuthScreen {
                        navigator.printTree("Before pushing screen two")
                        navigator.push(ScreenTwo)
                        navigator.printTree("After pushing screen two")
                    })
                    navigator.printTree("After pushing auth screen")
                }
            ) {
                Text("Go to ScreenTwo via Auth")
            }
        }
    }
}

object ScreenTwo : Screen {
    @Composable
    override fun Content() {
        Text("ScreenTwo")
    }
}
