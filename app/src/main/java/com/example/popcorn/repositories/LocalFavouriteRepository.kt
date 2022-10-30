package com.example.popcorn.repositories

import androidx.lifecycle.LiveData
import com.example.popcorn.infrastructure.database.FavouriteDatabase
import com.example.popcorn.model.local_dto.FavouriteItems
import com.example.popcorn.repositories.interfaces.IFavouriteRepository

class LocalFavouriteRepository(private val database: FavouriteDatabase) : IFavouriteRepository {
    override fun getItems(): LiveData<List<FavouriteItems>> {
        return database.Dao().fetchedMovies()
    }

    override suspend fun clearDatabase() {
        return database.Dao().clearTable()
    }

    override suspend fun addMovie(item: FavouriteItems) {
        return database.Dao().addItem(item)
    }

    override suspend fun deleteMovie(item: FavouriteItems) {
        return database.Dao().delete(item)
    }

}