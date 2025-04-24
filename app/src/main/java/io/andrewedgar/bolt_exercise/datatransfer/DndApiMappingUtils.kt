package io.andrewedgar.bolt_exercise.datatransfer

import io.andrewedgar.bolt_exercise.datatransfer.responses.ClassResponse
import io.andrewedgar.bolt_exercise.datatransfer.responses.ClassEntry
import io.andrewedgar.bolt_exercise.datatransfer.responses.FeatureEntry
import io.andrewedgar.bolt_exercise.datatransfer.responses.FeatureResponse
import io.andrewedgar.bolt_exercise.datatransfer.responses.MonsterEntry
import io.andrewedgar.bolt_exercise.datatransfer.responses.MonsterResponse
import io.andrewedgar.bolt_exercise.datatransfer.responses.SpellEntry
import io.andrewedgar.bolt_exercise.datatransfer.responses.SpellResponse
import io.andrewedgar.bolt_exercise.domain.models.CharacterClass
import io.andrewedgar.bolt_exercise.domain.models.Feature
import io.andrewedgar.bolt_exercise.domain.models.Monster
import io.andrewedgar.bolt_exercise.domain.models.Spell


object CharacterClassResponseToModelMapper {
    fun map(response: ClassResponse): List<CharacterClass> {
        return response.results.map { entry: ClassEntry ->
            CharacterClass(
                index = entry.index,
                name = entry.name,
                url = entry.url
            )
        }
    }
}

object FeatureResponseToModelMapper {
    fun map(response: FeatureResponse): List<Feature> {
        return response.results.map { mapFeatureEntry(it) }
    }

    private fun mapFeatureEntry(entry: FeatureEntry): Feature {
        return Feature(
            index = entry.index,
            name = entry.name,
            url = entry.url,
        )
    }
}

object MonsterResponseToModelMapper {
    fun map(response: MonsterResponse): List<Monster> {
        return response.results.map { mapMonsterEntry(it) }
    }

    private fun mapMonsterEntry(entry: MonsterEntry): Monster {
        return Monster(
            index = entry.index,
            name = entry.name,
            url = entry.url,
        )
    }
}

object SpellResponseToModelMapper {
    fun map(response: SpellResponse): List<Spell> {
        return response.results.map { mapSpellEntry(it) }
    }

    private fun mapSpellEntry(entry: SpellEntry): Spell {
        return Spell(
            index = entry.index,
            name = entry.name,
            url = entry.url,
            level = entry.level
        )
    }
}
