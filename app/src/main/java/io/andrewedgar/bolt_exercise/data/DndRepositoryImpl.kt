package io.andrewedgar.bolt_exercise.data

import io.andrewedgar.bolt_exercise.domain.Item
import io.andrewedgar.bolt_exercise.domain.DndRepository
import io.andrewedgar.bolt_exercise.domain.Result
import io.andrewedgar.bolt_exercise.remote.DndApi

class DndRepositoryImpl(private val dndApi: DndApi): DndRepository {
    override suspend fun getItems(): Result<List<Item>> {
        val itemList: List<Item> =
                ItemResponseToModelMapper.map(
            dndApi.getItems()
        )

        return when (itemList.isEmpty()) {
            true -> Result.Error(Throwable("No Entries Found"))
            else -> Result.Success(itemList)
        }
    }
}