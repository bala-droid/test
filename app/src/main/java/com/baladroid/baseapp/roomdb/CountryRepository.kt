package com.baladroid.baseapp.roomdb

import kotlinx.coroutines.flow.Flow


interface CountryRepository {

    fun getAllCountriesFromDB(): Flow<List<CountryTable>>

    suspend fun insert(countryTable: CountryTable)

    suspend fun update(countryTable: CountryTable)

    suspend fun delete()
}