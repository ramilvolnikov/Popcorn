package com.example.popcorn.repositories

import androidx.lifecycle.LiveData
import com.example.popcorn.infrastructure.database.MoviesDatabase
import com.example.popcorn.model.local_dto.MoviesItems
import com.example.popcorn.repositories.interfaces.IItemsRepository

class LocalItemsRepository(private val database: MoviesDatabase) : IItemsRepository {
    override fun getItems(): LiveData<List<MoviesItems>> {
        return database.Dao().fetchedMovies()
    }

    override suspend fun clearDatabase() {
        return database.Dao().clearTable()
    }

    override suspend fun addMovie(item: MoviesItems) {
        return database.Dao().addItem(item)
    }

}