package com.baladroid.baseapp.di

import com.baladroid.baseapp.data.repository.BaseRepositoryImpl
import com.baladroid.baseapp.domain.repository.BaseRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RespositoryModule {

    @Binds
    internal abstract fun provideBaseRepository(respositoryImpl: BaseRepositoryImpl): BaseRepository

}