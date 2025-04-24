package io.andrewedgar.bolt_exercise.di

import io.andrewedgar.bolt_exercise.domain.interactors.DndInteractor
import io.andrewedgar.bolt_exercise.domain.interactors.DndInteractorImpl
import org.koin.dsl.module

val interactorModule = module {
    factory<DndInteractor> { DndInteractorImpl(get()) }
}