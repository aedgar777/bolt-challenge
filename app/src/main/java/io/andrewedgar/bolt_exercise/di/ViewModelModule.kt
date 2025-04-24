package io.andrewedgar.bolt_exercise.di

import io.andrewedgar.bolt_exercise.ui.viewmodels.ClassListViewModel
import io.andrewedgar.bolt_exercise.ui.viewmodels.FeatureListViewModel
import io.andrewedgar.bolt_exercise.ui.viewmodels.MonsterListViewModel
import io.andrewedgar.bolt_exercise.ui.viewmodels.SpellListViewModel
import org.koin.core.module.dsl.*
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ClassListViewModel(get()) }
    viewModel { FeatureListViewModel(get()) }
    viewModel { MonsterListViewModel(get()) }
    viewModel { SpellListViewModel(get()) }

}