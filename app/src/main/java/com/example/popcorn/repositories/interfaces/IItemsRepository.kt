package com.example.popcorn.repositories.interfaces

import androidx.lifecycle.LiveData
import com.example.popcorn.model.local_dto.MoviesItems

interface IItemsRepository {
    fun getItems(): LiveData<List<MoviesItems>>
    suspend fun clearDatabase()
    suspend fun addMovie(item: MoviesItems)
}