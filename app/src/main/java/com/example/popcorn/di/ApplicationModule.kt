package com.example.popcorn.di

import android.app.Application
import androidx.room.Room
import com.example.popcorn.infrastructure.ServerClient
import com.example.popcorn.infrastructure.database.FavouriteDatabase
import com.example.popcorn.infrastructure.database.InfoDatabase
import com.example.popcorn.infrastructure.database.MoviesDatabase
import com.example.popcorn.infrastructure.interfaces.IServerClient
import com.example.popcorn.repositories.*
import com.example.popcorn.repositories.interfaces.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
    @Provides
    @Singleton
    fun providesServerClient() : IServerClient {
        return ServerClient()
    }

    @Provides
    fun provideNewsRepository(serverClient: IServerClient) : IMoviesRepository {
        return RemoteMoviesRepository(serverClient)
    }

    @Provides
    fun provideItemsRepository(serverClient: IServerClient) : IInfoRepository {
        return RemoteInfoRepository(serverClient)
    }

    @Provides
    fun provideRoom(application: Application) : MoviesDatabase {
        return Room.databaseBuilder(
            application,
            MoviesDatabase::class.java,
            "NewsDatabase"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideRoomInfo(application: Application) : InfoDatabase {
        return Room.databaseBuilder(
            application,
            InfoDatabase::class.java,
            "ItemDatabase"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideRoomFavourite(application: Application) : FavouriteDatabase {
        return Room.databaseBuilder(
            application,
            FavouriteDatabase::class.java,
            "FavouriteDatabase"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideArticlesRepository(database: MoviesDatabase) : IItemsRepository {
        return LocalItemsRepository(database)
    }

    @Provides
    fun provideInfoRepository(database: InfoDatabase) : IInfoItemsRepository {
        return LocalInfoRepository(database)
    }

    @Provides
        fun provideFavouriteRepository(database: FavouriteDatabase) : IFavouriteRepository {
        return LocalFavouriteRepository(database)
    }
}