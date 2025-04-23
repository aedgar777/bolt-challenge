package io.andrewedgar.bolt_exercise.di

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.observer.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.dsl.module
import android.util.Log
import io.andrewedgar.bolt_exercise.remote.DndApi
import io.andrewedgar.bolt_exercise.remote.ktor.DndKtorApiImpl
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation

private const val TIME_OUT = 6000

val networkModule = module {
    factory<DndApi> { DndKtorApiImpl(get())}

    single {
        HttpClient(Android) {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }

            engine {
                connectTimeout = TIME_OUT
                socketTimeout = TIME_OUT
            }

            install(ResponseObserver) {
                onResponse { response ->
                    Log.d("HTTP Response", "Status: ${response.status.value}")
                }
            }

            install(DefaultRequest) {
                header(HttpHeaders.ContentType, ContentType.Application.Json)
            }
        }
    }
}