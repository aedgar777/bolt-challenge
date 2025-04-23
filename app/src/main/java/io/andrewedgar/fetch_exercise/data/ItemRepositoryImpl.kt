package io.andrewedgar.fetch_exercise.data

import io.andrewedgar.fetch_exercise.domain.Item
import io.andrewedgar.fetch_exercise.domain.ItemRepository
import io.andrewedgar.fetch_exercise.domain.Result
import io.andrewedgar.fetch_exercise.remote.ItemApi

class ItemRepositoryImpl(private val itemApi: ItemApi): ItemRepository {
    override suspend fun getItems(): Result<List<Item>> {
        val itemList: List<Item> =
                ItemResponseToModelMapper.map(
            itemApi.getItems()
        )

        return when (itemList.isEmpty()) {
            true -> Result.Error(Throwable("No Entries Found"))
            else -> Result.Success(itemList)
        }
    }
}