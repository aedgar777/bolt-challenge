package io.andrewedgar.bolt_exercise.domain

interface DndRepository {
    suspend fun getItems(): Result<List<Item>>
}