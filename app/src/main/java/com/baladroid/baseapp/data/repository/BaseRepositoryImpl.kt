package com.baladroid.baseapp.data.repository

import com.baladroid.baseapp.domain.model.Country
import com.baladroid.baseapp.domain.repository.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton


@Singleton
class BaseRepositoryImpl : BaseRepository {
    override fun getAllCountries(): Flow<Country> {
        TODO("Not yet implemented")
    }


}
