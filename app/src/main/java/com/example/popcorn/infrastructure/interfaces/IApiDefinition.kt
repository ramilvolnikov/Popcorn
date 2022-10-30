package com.example.popcorn.infrastructure.interfaces

import com.example.popcorn.model.server_dto.InfoData
import com.example.popcorn.model.server_dto.MoviesData
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface IApiDefinition {
    @GET("MostPopularMovies/k_svfl15i6")
    //@GET("MostPopularMovies/k_ayp96jnz")
    fun getMovies() : Deferred<MoviesData>

    @GET("Title/k_svfl15i6/{id}/FullActor,FullCast,Posters,Images,Trailer,Ratings,Wikipedia,")
    //@GET("Title/k_ayp96jnz/{id}/FullActor,FullCast,Posters,Images,Trailer,Ratings,Wikipedia,")
    fun getInfo(@Path("id") id: String) : Deferred<InfoData>
}