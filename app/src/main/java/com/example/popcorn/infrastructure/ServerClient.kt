package com.example.popcorn.infrastructure

import com.example.popcorn.infrastructure.interfaces.IApiDefinition
import com.example.popcorn.infrastructure.interfaces.IServerClient
import com.example.popcorn.model.server_dto.*
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServerClient : IServerClient {

    val service : IApiDefinition

    init {
        val gson = GsonBuilder().create()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl(BASE_URL)
            .build()
        service = retrofit.create(IApiDefinition::class.java)
    }

    override suspend fun getMovies(): MoviesData {
        return try {
            val serverResult : MoviesData = service.getMovies().await()
            MoviesData(serverResult.items, serverResult.errorMessage)
        } catch (exception : HttpException) {
            MoviesData (arrayListOf(),"HttpException")
        }
    }

    override suspend fun getInfo(id: String): InfoData {
        return try {
            val serverResult : InfoData = service.getInfo(id).await()
            InfoData(serverResult.id,
                serverResult.title,
                serverResult.releaseDate,
                serverResult.plot,
                serverResult.image,
                serverResult.trailer
            )

        } catch (exception : HttpException) {
            InfoData ("", "", "", "", "", Trailer())
        }
    }

    companion object {
        private const val BASE_URL = "https://imdb-api.com/ru/API/"
    }

}