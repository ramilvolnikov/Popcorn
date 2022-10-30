package com.example.popcorn.infrastructure.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.popcorn.model.local_dto.MoviesItems

@Dao
abstract class MoviesDao {
    @Query("SELECT * FROM MOVIES")
    abstract fun fetchedMovies(): LiveData<List<MoviesItems>>

    @Query("DELETE FROM MOVIES")
    abstract fun clearTable()

    @Insert
    abstract fun addItem(article: MoviesItems)
}