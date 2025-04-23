package io.andrewedgar.fetch_exercise

import android.app.Application
import android.util.Log
import io.andrewedgar.fetch_exercise.database.ItemDatabase
import io.andrewedgar.fetch_exercise.di.databaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import io.andrewedgar.fetch_exercise.di.interactorModule
import io.andrewedgar.fetch_exercise.di.networkModule
import io.andrewedgar.fetch_exercise.di.viewModelModule
import io.andrewedgar.fetch_exercise.di.repositoryModule
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.getValue

class FetchApplication: Application(), KoinComponent {


    private val itemDatabase: ItemDatabase? by inject()

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@FetchApplication)
            modules(networkModule, repositoryModule, databaseModule, interactorModule, viewModelModule)
        }

        // itemDatabase is now available after Koin is started,
        // and injected by the 'inject()' delegate.

        Log.d("KoinDebug", "ItemDatabase instance: $itemDatabase")
        //If you still want a try/catch:

        val itemDatabaseSafe : ItemDatabase? = try {
            inject<ItemDatabase>().value
        } catch (e: Exception) {
            Log.e("KoinDebug", "Error getting ItemDatabase: ${e.message}", e)
            null
        }

        Log.d("KoinDebug", "ItemDatabase instance safe: $itemDatabaseSafe")

    }

}