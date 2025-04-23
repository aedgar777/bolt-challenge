package io.andrewedgar.bolt_exercise.data
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ItemResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("listId")
    val listId: Int,
    @SerialName("name")
    val name: String?
)