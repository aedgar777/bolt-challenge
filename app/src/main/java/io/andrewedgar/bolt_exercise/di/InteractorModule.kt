package io.andrewedgar.bolt_exercise.di

import io.andrewedgar.bolt_exercise.domain.interactors.ItemInteractor
import io.andrewedgar.bolt_exercise.domain.interactors.DndInteractorImpl
import org.koin.dsl.module

val interactorModule = module {
    factory<ItemInteractor> { DndInteractorImpl(get(), get()) }
}