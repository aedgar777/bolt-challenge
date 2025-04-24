package io.andrewedgar.bolt_exercise.datatransfer.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ClassResponse(
    val count: Int,
    val results: List<ClassEntry>
)
@Serializable
data class ClassEntry(
    val index: String,
    val name: String,
    val url: String
)
