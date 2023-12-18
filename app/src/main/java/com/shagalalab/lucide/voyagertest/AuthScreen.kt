package com.shagalalab.lucide.voyagertest

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

data class AuthScreen(val onLoginSuccess: () -> Unit) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Button(onClick = {
                navigator.printTree("Auth screen, before popUntilRoot")
                navigator.popUntilRoot()
                navigator.printTree("Auth screen, after popUntilRoot")
                onLoginSuccess()
            }) {
                Text("Login")
            }
        }
    }
}
