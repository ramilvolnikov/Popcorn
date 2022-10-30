package com.example.popcorn.infrastructure.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.popcorn.model.local_dto.MoviesItems

@Database(entities = [MoviesItems::class], version = 4)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun Dao(): MoviesDao
}