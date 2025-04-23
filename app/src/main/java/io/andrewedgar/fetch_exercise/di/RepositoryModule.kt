package io.andrewedgar.fetch_exercise.di

import io.andrewedgar.fetch_exercise.data.ItemRepositoryImpl
import io.andrewedgar.fetch_exercise.domain.ItemRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<ItemRepository> { ItemRepositoryImpl(get()) }
}