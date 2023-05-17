package com.baladroid.baseapp.di

import android.content.Context
import androidx.room.Room
import com.baladroid.baseapp.roomdb.AppDB
import com.baladroid.baseapp.roomdb.CountryDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ApplicationDataModule {
    private val DATABASE_NAME: String = "app-user"

    @Provides
    fun provideAppUserDao(appDB: AppDB): CountryDAO {
        return appDB.getCountriesDAO()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDB {
        return Room.databaseBuilder(
            appContext,
            AppDB::class.java,
            DATABASE_NAME
        ).build()
    }
}