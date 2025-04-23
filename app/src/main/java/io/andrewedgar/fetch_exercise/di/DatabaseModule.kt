package io.andrewedgar.fetch_exercise.di

import android.app.Application
import androidx.room.Room
import io.andrewedgar.fetch_exercise.database.ItemDao
import io.andrewedgar.fetch_exercise.database.ItemDatabase
import org.koin.dsl.module

fun provideDatabase(application: Application): ItemDatabase =
    Room.databaseBuilder(
        application,
        ItemDatabase::class.java,
        "item_database"
    ).build()


fun provideDao(database: ItemDatabase): ItemDao = database.itemDao()

val databaseModule = module {
    single { provideDatabase(get()) }
    single { provideDao(get()) }
}