package io.andrewedgar.bolt_exercise.di

import io.andrewedgar.bolt_exercise.data.DndRepositoryImpl
import io.andrewedgar.bolt_exercise.domain.DndRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<DndRepository> { DndRepositoryImpl(get()) }
}