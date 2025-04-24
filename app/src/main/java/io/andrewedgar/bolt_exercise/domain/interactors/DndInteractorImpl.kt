package io.andrewedgar.bolt_exercise.domain.interactors

import io.andrewedgar.bolt_exercise.domain.models.CharacterClass
import io.andrewedgar.bolt_exercise.domain.DndRepository
import io.andrewedgar.bolt_exercise.domain.Result
import io.andrewedgar.bolt_exercise.domain.models.Feature
import io.andrewedgar.bolt_exercise.domain.models.Monster
import io.andrewedgar.bolt_exercise.domain.models.Spell

class DndInteractorImpl(private val dndRepository: DndRepository) : DndInteractor  {
    override suspend fun getClasses(): Result<List<CharacterClass>> {
        return dndRepository.getClasses()
    }

    override suspend fun getFeatures(): Result<List<Feature>> {
        return dndRepository.getFeatures()
    }

    override suspend fun getMonsters(): Result<List<Monster>> {
        return dndRepository.getMonsters()
    }

    override suspend fun getSpells(): Result<List<Spell>> {
        return dndRepository.getSpells()
    }
}