package io.andrewedgar.fetch_exercise.di

import io.andrewedgar.fetch_exercise.domain.interactors.ItemInteractor
import io.andrewedgar.fetch_exercise.domain.interactors.ItemInteractorImpl
import org.koin.dsl.module

val interactorModule = module {
    factory<ItemInteractor> { ItemInteractorImpl(get(), get()) }
}