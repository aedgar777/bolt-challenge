package io.andrewedgar.fetch_exercise.domain

interface ItemRepository {
    suspend fun getItems(): Result<List<Item>>
}