package io.andrewedgar.bolt_exercise.domain

import io.andrewedgar.bolt_exercise.domain.models.CharacterClass
import io.andrewedgar.bolt_exercise.domain.models.Feature
import io.andrewedgar.bolt_exercise.domain.models.Monster
import io.andrewedgar.bolt_exercise.domain.models.Spell

interface DndRepository {
    suspend fun getClasses(): Result<List<CharacterClass>>
    suspend fun getFeatures(): Result<List<Feature>>
    suspend fun getMonsters(): Result<List<Monster>>
    suspend fun getSpells(): Result<List<Spell>>
}