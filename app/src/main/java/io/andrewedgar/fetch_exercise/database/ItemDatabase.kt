package io.andrewedgar.fetch_exercise.database

import androidx.room.Database
import androidx.room.RoomDatabase
import io.andrewedgar.fetch_exercise.domain.Item
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Database(entities = [Item::class], version = 1)
abstract class ItemDatabase: RoomDatabase() {
    abstract fun itemDao(): ItemDao
}


@Dao
interface ItemDao {
    @Query("SELECT * FROM item")
    suspend fun getAllItems(): List<Item>

    @Query("SELECT * FROM item WHERE list_id = :listId")
    suspend fun getItemByListId(listId: Int): List<Item>

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<Item>)

}
