package io.andrewedgar.fetch_exercise.ui.screens.listscreen

import androidx.compose.runtime.Composable
import io.andrewedgar.fetch_exercise.domain.Item


@Composable
fun ItemList(items: List<Item>) {

    items.forEach { item ->
        ListItemView(item)
    }

}
