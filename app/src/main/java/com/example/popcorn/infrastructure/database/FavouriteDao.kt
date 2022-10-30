package com.example.popcorn.infrastructure.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.popcorn.model.local_dto.FavouriteItems

@Dao
abstract class FavouriteDao {
    @Query("SELECT * FROM FAVOURITE")
    abstract fun fetchedMovies(): LiveData<List<FavouriteItems>>

    @Query("DELETE FROM FAVOURITE")
    abstract fun clearTable()

    @Insert
    abstract fun addItem(article: FavouriteItems)

    @Delete
    abstract  fun delete(article: FavouriteItems)

}