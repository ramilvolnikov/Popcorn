package com.example.popcorn.infrastructure.interfaces

import com.example.popcorn.model.server_dto.InfoData
import com.example.popcorn.model.server_dto.MoviesData

interface IServerClient {
    suspend fun getMovies() : MoviesData
    suspend fun getInfo(id: String) : InfoData
}