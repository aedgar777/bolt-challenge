package io.andrewedgar.bolt_exercise.domain.interactors

import io.andrewedgar.bolt_exercise.database.ItemDatabase
import io.andrewedgar.bolt_exercise.domain.Item
import io.andrewedgar.bolt_exercise.domain.DndRepository
import io.andrewedgar.bolt_exercise.domain.Result

class DndInteractorImpl(private val dndRepository: DndRepository, private val itemDatabase: ItemDatabase) : ItemInteractor  {
    override suspend fun getItemsFromRemote(): Result<List<Item>> {
        return dndRepository.getItems()
    }

    override suspend fun getItemsFromLocal(): List<Item> {
       return itemDatabase.itemDao().getAllItems()
    }

    override suspend fun getItemsFromLocalByListId(listId: Int): List<Item> {
        return itemDatabase.itemDao().getItemByListId(listId)
    }

    override suspend fun saveItemsToLocal(items: List<Item>) {
        return itemDatabase.itemDao().insertAll(items)
    }
}