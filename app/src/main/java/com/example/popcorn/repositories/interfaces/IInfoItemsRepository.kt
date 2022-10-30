package com.example.popcorn.repositories.interfaces

import androidx.lifecycle.LiveData
import com.example.popcorn.model.local_dto.InfoItems

interface IInfoItemsRepository {
    fun getItems(id: String): LiveData<InfoItems>
    suspend fun clearDatabase()
    suspend fun addMovie(item: InfoItems)
}