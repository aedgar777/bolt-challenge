package io.andrewedgar.bolt_exercise.ui.screens.monsterscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.andrewedgar.bolt_exercise.ui.viewmodels.MonsterListUiState


@Composable
fun MonsterScreen(
    uiState: MonsterListUiState
) {


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        when (uiState) {
            is MonsterListUiState.Loading -> {
                CircularProgressIndicator()
            }

            is MonsterListUiState.Success -> {
                MonsterListView(uiState.items)
            }

            is MonsterListUiState.Error -> {
                Text(uiState.message.toString())
            }
        }
    }
    }
