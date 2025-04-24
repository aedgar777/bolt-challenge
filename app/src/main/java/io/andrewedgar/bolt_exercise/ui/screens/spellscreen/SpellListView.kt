package io.andrewedgar.bolt_exercise.ui.screens.spellscreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import io.andrewedgar.bolt_exercise.domain.models.CharacterClass
import io.andrewedgar.bolt_exercise.domain.models.Spell
import io.andrewedgar.bolt_exercise.ui.viewmodels.SpellListViewModel


@Composable
fun SpellListView(spells: List<Spell>) {

    LazyColumn {
        items(spells.size) { index ->
            SpellListItemView(spells[index])
        }
    }
}
