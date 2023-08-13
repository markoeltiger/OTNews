package com.mark.orangetask.di

import com.mark.orangetask.data.repository.NewsRepoImpl
import com.mark.orangetask.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindNewsRepository(
        stockRepositoryImpl: NewsRepoImpl
    ): NewsRepository
}