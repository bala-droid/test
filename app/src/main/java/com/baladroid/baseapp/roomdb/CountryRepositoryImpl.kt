package com.baladroid.baseapp.roomdb

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor (private val countryDAO: CountryDAO): CountryRepository {


    suspend fun numberOfItemsInDB() = countryDAO.numberOfItemsInDB()


    override fun getAllCountriesFromDB(): Flow<List<CountryTable>> {
        return countryDAO.getCurrentUser()
    }

    override suspend fun insert(countryTable: CountryTable) {
        return countryDAO.insert(countryTable)
    }

    override suspend fun update(countryTable: CountryTable) {
        return countryDAO.update(countryTable)
    }

    override suspend fun delete() {
        return countryDAO.delete()
    }
}