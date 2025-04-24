package io.andrewedgar.bolt_exercise.ui.screens.classlistscreen


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
import io.andrewedgar.bolt_exercise.domain.models.CharacterClass


@Composable
fun ClassListItemView(characterClass: CharacterClass) {

    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(modifier = Modifier.padding(8.dp), fontSize = 30.sp, color = Color.White, text = characterClass.name)
        HorizontalDivider(color = Color.White)
    }


}