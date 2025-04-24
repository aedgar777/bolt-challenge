package io.andrewedgar.bolt_exercise.remote.ktor

import io.andrewedgar.bolt_exercise.datatransfer.responses.ClassResponse
import io.andrewedgar.bolt_exercise.datatransfer.responses.FeatureResponse
import io.andrewedgar.bolt_exercise.datatransfer.responses.MonsterResponse
import io.andrewedgar.bolt_exercise.datatransfer.responses.SpellResponse
import io.andrewedgar.bolt_exercise.remote.DndApi
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class DndKtorApiImpl(val client: HttpClient) : DndApi {

    private val baseUrl = "https://www.dnd5eapi.co/api/2014/"
    private val classUrl = "$baseUrl/classes"
    private val featureUrl = "$baseUrl/features"
    private val monsterUrl = "$baseUrl/monsters"
    private val spellUrl = "$baseUrl/spells"

    override suspend fun getClasses(): ClassResponse {
        val response: HttpResponse = client.get(classUrl)
        return response.body()
    }

    override suspend fun getFeatures(): FeatureResponse {
        val response: HttpResponse = client.get(featureUrl)
        return response.body()
    }

    override suspend fun getMonsters(): MonsterResponse{
        val response: HttpResponse = client.get(monsterUrl)
        return response.body()
    }

    override suspend fun getSpells(): SpellResponse {
        val response: HttpResponse = client.get(spellUrl)
        return response.body()
    }

}