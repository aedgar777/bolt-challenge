package io.andrewedgar.bolt_exercise.ui.screens.monsterscreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import io.andrewedgar.bolt_exercise.domain.models.Monster

@Composable
fun MonsterListView(monsterList: List<Monster>) {

    LazyColumn {
        items(monsterList.size) { index ->
            MonsterListItemView(monsterList[index])
        }

    }
}