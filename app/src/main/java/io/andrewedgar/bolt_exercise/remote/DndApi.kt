package io.andrewedgar.bolt_exercise.remote

import io.andrewedgar.bolt_exercise.data.ItemResponse

interface DndApi {
    suspend fun getItems(): List<ItemResponse>
}