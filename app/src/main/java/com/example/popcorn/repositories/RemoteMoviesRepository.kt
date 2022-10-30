package com.example.popcorn.repositories

import com.example.popcorn.infrastructure.interfaces.IServerClient
import com.example.popcorn.model.server_dto.MoviesData
import com.example.popcorn.repositories.interfaces.IMoviesRepository

class RemoteMoviesRepository(private val serverClient: IServerClient) : IMoviesRepository {
    override suspend fun getMovies(): MoviesData {
        return serverClient.getMovies()
    }
}