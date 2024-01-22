package com.reysand.bybit.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.reysand.bybit.ui.screens.HomeScreen
import com.reysand.bybit.ui.viewmodel.BybitViewModel

@Composable
fun BybitApp(bybitViewModel: BybitViewModel = viewModel()) {
    Scaffold {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colorScheme.background
        ) {
            HomeScreen(bybitViewModel = bybitViewModel)
        }
    }
}