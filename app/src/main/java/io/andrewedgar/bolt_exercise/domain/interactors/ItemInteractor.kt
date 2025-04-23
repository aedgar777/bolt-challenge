package io.andrewedgar.bolt_exercise.domain.interactors

import io.andrewedgar.bolt_exercise.domain.Item
import io.andrewedgar.bolt_exercise.domain.Result

interface ItemInteractor {
    suspend fun getItemsFromRemote(): Result<List<Item>>
    suspend fun getItemsFromLocal(): List<Item>
    suspend fun getItemsFromLocalByListId(listId: Int): List<Item>
    suspend fun saveItemsToLocal(items: List<Item>)
}