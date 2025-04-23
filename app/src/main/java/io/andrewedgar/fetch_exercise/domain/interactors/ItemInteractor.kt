package io.andrewedgar.fetch_exercise.domain.interactors

import io.andrewedgar.fetch_exercise.domain.Item
import io.andrewedgar.fetch_exercise.domain.Result

interface ItemInteractor {
    suspend fun getItemsFromRemote(): Result<List<Item>>
    suspend fun getItemsFromLocal(): List<Item>
    suspend fun getItemsFromLocalByListId(listId: Int): List<Item>
    suspend fun saveItemsToLocal(items: List<Item>)
}