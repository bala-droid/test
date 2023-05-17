package com.baladroid.baseapp.domain.repository

import com.baladroid.baseapp.domain.model.Country
import kotlinx.coroutines.flow.Flow


interface BaseRepository {
    fun getAllCountries(): Flow<Country>
}