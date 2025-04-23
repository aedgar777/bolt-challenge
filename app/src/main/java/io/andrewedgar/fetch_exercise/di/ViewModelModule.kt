package io.andrewedgar.fetch_exercise.di

import io.andrewedgar.fetch_exercise.ui.ItemListViewModel
import org.koin.core.module.dsl.*
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ItemListViewModel(get()) }
}