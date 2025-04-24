package io.andrewedgar.bolt_exercise.remote


import io.andrewedgar.bolt_exercise.datatransfer.responses.ClassResponse
import io.andrewedgar.bolt_exercise.datatransfer.responses.FeatureResponse
import io.andrewedgar.bolt_exercise.datatransfer.responses.MonsterResponse
import io.andrewedgar.bolt_exercise.datatransfer.responses.SpellResponse


interface DndApi {
    suspend fun getClasses(): ClassResponse
    suspend fun getFeatures(): FeatureResponse
    suspend fun getMonsters(): MonsterResponse
    suspend fun getSpells(): SpellResponse

}