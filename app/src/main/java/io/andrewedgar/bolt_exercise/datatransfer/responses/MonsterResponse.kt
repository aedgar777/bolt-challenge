package io.andrewedgar.bolt_exercise.datatransfer.responses

import kotlinx.serialization.Serializable


@Serializable
data class MonsterResponse(
    val count: Int,
    val results: List<MonsterEntry>
)

@Serializable
data class MonsterEntry(
    val index: String,
    val name: String,
    val url: String
)