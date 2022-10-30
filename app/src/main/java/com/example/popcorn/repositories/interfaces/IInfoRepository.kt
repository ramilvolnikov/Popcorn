package com.example.popcorn.repositories.interfaces

import com.example.popcorn.model.server_dto.InfoData

interface IInfoRepository {
    suspend fun getInfo(id: String) : InfoData
}