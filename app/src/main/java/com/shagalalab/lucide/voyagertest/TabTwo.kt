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
import androidx.core.R
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

object TabTwo : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val icon = painterResource(R.drawable.ic_call_answer_video)

            return remember {
                TabOptions(
                    index = 1u,
                    title = "Two",
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        Navigator(ScreenThree)
    }
}

object ScreenThree : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Button(onClick = { navigator.push(ScreenFour) }) {
                Text("Go to ScreenFour")
            }
        }
    }
}

object ScreenFour : Screen {
    @Composable
    override fun Content() {
        Text("end")
    }
}

