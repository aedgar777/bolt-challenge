package io.andrewedgar.bolt_exercise.ui.screens.classlistscreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.andrewedgar.bolt_exercise.domain.models.CharacterClass
import io.andrewedgar.bolt_exercise.domain.models.Monster


@Composable
fun ClassListView(classList: List<CharacterClass>) {

    LazyColumn {
        items(classList.size) { index ->
            ClassListItemView(classList[index])
        }
    }
}
