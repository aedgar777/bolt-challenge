package io.andrewedgar.bolt_exercise.domain.interactors

import io.andrewedgar.bolt_exercise.domain.models.CharacterClass
import io.andrewedgar.bolt_exercise.domain.Result
import io.andrewedgar.bolt_exercise.domain.models.Feature
import io.andrewedgar.bolt_exercise.domain.models.Monster
import io.andrewedgar.bolt_exercise.domain.models.Spell

interface DndInteractor {
    suspend fun getClasses(): Result<List<CharacterClass>>
    suspend fun getFeatures(): Result<List<Feature>>
    suspend fun getMonsters(): Result<List<Monster>>
    suspend fun getSpells(): Result<List<Spell>>

}