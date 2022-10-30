package com.example.popcorn.infrastructure.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.popcorn.model.local_dto.FavouriteItems

@Database(entities = [FavouriteItems::class], version = 1)
abstract class FavouriteDatabase : RoomDatabase() {
    abstract fun Dao(): FavouriteDao
}