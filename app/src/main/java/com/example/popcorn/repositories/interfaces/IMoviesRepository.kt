package com.example.popcorn.repositories.interfaces

import com.example.popcorn.model.server_dto.MoviesData

interface IMoviesRepository {
    suspend fun getMovies() : MoviesData
}