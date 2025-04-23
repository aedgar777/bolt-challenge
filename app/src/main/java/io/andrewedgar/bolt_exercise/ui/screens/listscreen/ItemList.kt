package io.andrewedgar.bolt_exercise.ui.screens.listscreen

import androidx.compose.runtime.Composable
import io.andrewedgar.bolt_exercise.domain.Item


@Composable
fun ItemList(items: List<Item>) {

    items.forEach { item ->
        ListItemView(item)
    }

}
