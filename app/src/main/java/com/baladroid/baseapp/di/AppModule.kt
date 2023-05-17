package com.baladroid.baseapp.di

import com.baladroid.baseapp.domain.repository.BaseRepository
import com.baladroid.baseapp.presentation.main.MainActivity
import com.baladroid.baseapp.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMainActivity(): MainActivity = MainActivity.getInstance() as MainActivity


    @Provides
    fun provideUseCasesCountries(
        repo: BaseRepository
    ) = CountriesUseCase(
        getAllCountries = GetAllCountries(repo)
    )

}