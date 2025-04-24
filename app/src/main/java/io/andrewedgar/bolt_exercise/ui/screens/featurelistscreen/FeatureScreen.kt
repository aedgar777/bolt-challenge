package io.andrewedgar.bolt_exercise.ui.screens.featurelistscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.andrewedgar.bolt_exercise.ui.viewmodels.FeatureListUiState


@Composable
fun FeatureScreen(
    uiState: FeatureListUiState
) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        when (uiState) {
            is FeatureListUiState.Loading -> {
                CircularProgressIndicator()
            }

            is FeatureListUiState.Success -> {
                FeatureListView(uiState.items)
            }

            is FeatureListUiState.Error -> {
                Text(uiState.message.toString())
            }
        }
    }
}