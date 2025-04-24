package io.andrewedgar.bolt_exercise.ui.screens.spellscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.andrewedgar.bolt_exercise.ui.viewmodels.SpellListUiState

@Composable
fun SpellScreen(
    uiState: SpellListUiState
) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        when (uiState) {
            is SpellListUiState.Loading -> {
                CircularProgressIndicator()
            }

            is SpellListUiState.Success -> {
                SpellListView(uiState.items)
            }

            is SpellListUiState.Error -> {
                Text(uiState.message.toString())
            }
        }
    }
    }
