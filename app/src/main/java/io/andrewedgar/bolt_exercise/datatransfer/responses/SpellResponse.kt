package io.andrewedgar.bolt_exercise.datatransfer.responses

import kotlinx.serialization.Serializable

@Serializable
data class SpellResponse(
    val count: Int,
    val results: List<SpellEntry>
)

@Serializable
data class SpellEntry(
    val index: String,
    val name: String,
    val url: String,
    val level: Int
)