package com.example.popcorn.repositories

import com.example.popcorn.infrastructure.interfaces.IServerClient
import com.example.popcorn.model.server_dto.InfoData
import com.example.popcorn.repositories.interfaces.IInfoRepository

class RemoteInfoRepository(private val serverClient: IServerClient) : IInfoRepository {
    override suspend fun getInfo(id: String): InfoData {
        return serverClient.getInfo(id)
    }
}