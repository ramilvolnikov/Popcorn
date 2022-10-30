package com.example.popcorn.repositories.interfaces

import androidx.lifecycle.LiveData
import com.example.popcorn.model.local_dto.FavouriteItems

interface IFavouriteRepository {
    fun getItems(): LiveData<List<FavouriteItems>>
    suspend fun clearDatabase()
    suspend fun addMovie(item: FavouriteItems)
    suspend fun deleteMovie(item: FavouriteItems)
}