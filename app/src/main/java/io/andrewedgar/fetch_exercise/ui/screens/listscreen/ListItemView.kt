package io.andrewedgar.fetch_exercise.ui.screens.listscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import io.andrewedgar.fetch_exercise.domain.Item


@Composable
fun ListItemView(item: Item) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(color = Color.White, text = "List Id: ${item.listId}")
        Text(color = Color.White, text = "Name: ${item.name}")
        Text(color = Color.White, text = "Id: ${item.id}")
    }


}