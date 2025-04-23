package io.andrewedgar.bolt_exercise.di

import io.andrewedgar.bolt_exercise.ui.ItemListViewModel
import org.koin.core.module.dsl.*
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ItemListViewModel(get()) }
}