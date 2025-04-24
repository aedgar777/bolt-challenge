package io.andrewedgar.bolt_exercise.ui.screens.classlistscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.andrewedgar.bolt_exercise.ui.viewmodels.ClassListUiState

@Composable
fun ClassScreen(
    uiState: ClassListUiState
) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        when (uiState) {
            is ClassListUiState.Loading -> {
                CircularProgressIndicator()
            }

            is ClassListUiState.Success -> {
                ClassListView(uiState.items)
            }

            is ClassListUiState.Error -> {
                Text(uiState.message.toString())
            }
        }
    }
    }

