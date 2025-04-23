package io.andrewedgar.bolt_exercise.remote.ktor

import io.andrewedgar.bolt_exercise.data.ItemResponse
import io.andrewedgar.bolt_exercise.remote.DndApi
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class DndKtorApiImpl(val client: HttpClient) : DndApi {

    private val baseUrl = "https://www.dnd5eapi.co/api/2014/"

    override suspend fun getItems(): List<ItemResponse> {
        val response: HttpResponse = client.get(baseUrl)
        return response.body()
    }

}