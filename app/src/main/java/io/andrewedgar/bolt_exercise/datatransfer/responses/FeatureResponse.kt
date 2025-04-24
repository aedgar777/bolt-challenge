package io.andrewedgar.bolt_exercise.datatransfer.responses

import kotlinx.serialization.Serializable


@Serializable
data class FeatureResponse(
    val count: Int,
    val results: List<FeatureEntry>
)

@Serializable
data class FeatureEntry(
    val index: String,
    val name: String,
    val url: String
)
