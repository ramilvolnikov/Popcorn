package com.example.popcorn.repositories

import androidx.lifecycle.LiveData
import com.example.popcorn.infrastructure.database.InfoDatabase
import com.example.popcorn.model.local_dto.InfoItems
import com.example.popcorn.repositories.interfaces.IInfoItemsRepository

class LocalInfoRepository(private val database: InfoDatabase) : IInfoItemsRepository {
    override fun getItems(id: String): LiveData<InfoItems> {
        return database.Dao().fetchedInfo()
    }

    override suspend fun clearDatabase() {
        return database.Dao().clearTable()
    }

    override suspend fun addMovie(item: InfoItems) {
        return database.Dao().addItem(item)
    }
}