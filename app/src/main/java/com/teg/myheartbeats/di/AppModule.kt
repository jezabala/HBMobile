package com.teg.myheartbeats.di

import com.teg.myheartbeats.data.sources.RemoteDataSource
import com.teg.myheartbeats.domain.respository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRepository(
        remoteDataSource: RemoteDataSource
    ): Repository {
        return Repository(
            remoteDataSource = remoteDataSource
        )
    }

}