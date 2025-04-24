package io.andrewedgar.bolt_exercise.ui.screens.spellscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.andrewedgar.bolt_exercise.domain.models.Spell


@Composable
fun SpellListItemView(spell: Spell) {

    Column (
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Text(modifier = Modifier.padding(8.dp), fontSize = 30.sp,color = Color.White, text = spell.name)
        Text(modifier = Modifier.padding(8.dp), fontSize = 30.sp,color = Color.White, text = "Level ${spell.level}")
        HorizontalDivider(color = Color.White)
    }


}