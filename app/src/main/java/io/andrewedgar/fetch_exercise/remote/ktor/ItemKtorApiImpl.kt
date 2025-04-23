package io.andrewedgar.fetch_exercise.remote.ktor

import io.andrewedgar.fetch_exercise.data.ItemResponse
import io.andrewedgar.fetch_exercise.remote.ItemApi
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class ItemKtorApiImpl(val client: HttpClient) : ItemApi {

    private val url = "https://fetch-hiring.s3.amazonaws.com/hiring.json"

    override suspend fun getItems(): List<ItemResponse> {
        val response: HttpResponse = client.get(url)
        return response.body()
    }

}