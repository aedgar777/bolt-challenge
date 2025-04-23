package io.andrewedgar.fetch_exercise.remote

import io.andrewedgar.fetch_exercise.data.ItemResponse

interface ItemApi {
    suspend fun getItems(): List<ItemResponse>
}