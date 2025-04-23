package io.andrewedgar.bolt_exercise.data

import io.andrewedgar.bolt_exercise.domain.Item


object ItemResponseToModelMapper : Mapper< List<ItemResponse>, List<Item>> {
     override fun map(from: List<ItemResponse>): List<Item> {

        return from.sortedBy { it.listId }.map {
            Item(id = it.id, listId = it.listId, name = it.name.toString())
        }
    }
}
