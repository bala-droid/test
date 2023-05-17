package com.baladroid.baseapp.roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey




@Entity(tableName = "country")
data class CountryTable(@ColumnInfo(name = "id") @PrimaryKey val id: String = "",
                    @ColumnInfo(name = "name")val name: String? = "",
                    @ColumnInfo(name = "continent")val dob: String? = ""
)
