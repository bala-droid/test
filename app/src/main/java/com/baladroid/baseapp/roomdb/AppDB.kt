package com.baladroid.baseapp.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(CountryTable::class), version = 1, exportSchema = false)
abstract class AppDB : RoomDatabase() {

    abstract fun getCountriesDAO(): CountryDAO

}