package io.andrewedgar.bolt_exercise.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item")
data class Item(
    @PrimaryKey val id:Int,
    @ColumnInfo(name = "list_id") val listId:Int,
    @ColumnInfo (name = "name") val name:String)