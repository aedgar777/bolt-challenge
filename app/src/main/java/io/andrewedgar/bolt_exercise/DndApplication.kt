package io.andrewedgar.bolt_exercise

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import io.andrewedgar.bolt_exercise.di.interactorModule
import io.andrewedgar.bolt_exercise.di.networkModule
import io.andrewedgar.bolt_exercise.di.viewModelModule
import io.andrewedgar.bolt_exercise.di.repositoryModule
import org.koin.core.component.KoinComponent

class DndApplication: Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@DndApplication)
            modules(networkModule, repositoryModule, interactorModule, viewModelModule)
        }

    }
}