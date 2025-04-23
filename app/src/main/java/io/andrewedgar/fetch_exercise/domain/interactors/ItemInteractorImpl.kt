package io.andrewedgar.fetch_exercise.domain.interactors

import io.andrewedgar.fetch_exercise.database.ItemDatabase
import io.andrewedgar.fetch_exercise.domain.Item
import io.andrewedgar.fetch_exercise.domain.ItemRepository
import io.andrewedgar.fetch_exercise.domain.Result

class ItemInteractorImpl(private val itemRepository: ItemRepository, private val itemDatabase: ItemDatabase) : ItemInteractor  {
    override suspend fun getItemsFromRemote(): Result<List<Item>> {
        return itemRepository.getItems()
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