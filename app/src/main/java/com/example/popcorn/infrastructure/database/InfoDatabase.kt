package com.example.popcorn.infrastructure.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.popcorn.model.local_dto.InfoItems

@Database(entities = [InfoItems::class], version = 1)
abstract class InfoDatabase : RoomDatabase() {
    abstract fun Dao(): InfoDao
}