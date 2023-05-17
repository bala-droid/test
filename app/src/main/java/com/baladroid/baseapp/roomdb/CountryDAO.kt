package com.baladroid.baseapp.roomdb

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDAO {

    // below is the insert method for
    // adding a new entry to our database.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(countryTable: CountryTable)

    // below is the delete method
    // for deleting our note.
 /*   @Delete
    suspend fun delete(user: AppUser)*/

    @Query("DELETE FROM country")
    suspend fun delete()

    // below is the method to read all the notes
    // from our database we have specified the query for it.
    // inside the query we are arranging it in ascending
    // order on below line and we are specifying
    // the table name from which
    // we have to get the data.
    @Query("Select * from country")
    fun getCurrentUser(): Flow<List<CountryTable>>

    // below method is use to update the note.
    @Update
    suspend fun update(countryTable: CountryTable)

    @Query("SELECT count(id) FROM country")
    suspend fun numberOfItemsInDB() : Int // suspend keyword to run in coroutine

}