package io.andrewedgar.bolt_exercise.datatransfer

import io.andrewedgar.bolt_exercise.domain.models.CharacterClass
import io.andrewedgar.bolt_exercise.domain.DndRepository
import io.andrewedgar.bolt_exercise.domain.Result
import io.andrewedgar.bolt_exercise.domain.models.Feature
import io.andrewedgar.bolt_exercise.domain.models.Monster
import io.andrewedgar.bolt_exercise.domain.models.Spell
import io.andrewedgar.bolt_exercise.remote.DndApi

class DndRepositoryImpl(private val dndApi: DndApi) : DndRepository {

    override suspend fun getClasses(): Result<List<CharacterClass>> {
        return mapApiResponse(
            apiCall = { dndApi.getClasses() },
            mapper = CharacterClassResponseToModelMapper::map
        )
    }

    override suspend fun getFeatures(): Result<List<Feature>> {
        return mapApiResponse(
            apiCall = { dndApi.getFeatures() },
            mapper = FeatureResponseToModelMapper::map
        )
    }

    override suspend fun getMonsters(): Result<List<Monster>> {
        return mapApiResponse(
            apiCall = { dndApi.getMonsters() },
            mapper = MonsterResponseToModelMapper::map
        )
    }

    override suspend fun getSpells(): Result<List<Spell>> {
        return mapApiResponse(
            apiCall = { dndApi.getSpells() },
            mapper = SpellResponseToModelMapper::map
        )
    }

    // Helper function to handle API calls and mapping
    private suspend fun <T, R> mapApiResponse(
        apiCall: suspend () -> T,
        mapper: (T) -> List<R>
    ): Result<List<R>> {
        val response = apiCall()
        val mappedList = mapper(response)
        return if (mappedList.isEmpty()) {
            Result.Error(Throwable("No Entries Found"))
        } else {
            Result.Success(mappedList)
        }
    }
}