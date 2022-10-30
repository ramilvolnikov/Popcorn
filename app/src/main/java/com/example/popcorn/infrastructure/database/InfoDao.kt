package com.example.popcorn.infrastructure.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.popcorn.model.local_dto.InfoItems

@Dao
abstract class InfoDao {
    @Query("SELECT * FROM INFO")
    abstract fun fetchedInfo(): LiveData<InfoItems>

    @Query("DELETE FROM INFO")
    abstract fun clearTable()

    @Insert
    abstract fun addItem(article: InfoItems)

}