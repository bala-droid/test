package com.baladroid.baseapp.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

object DateUtils {

    @RequiresApi(Build.VERSION_CODES.O)
    fun getCurrentDateAndTime(): String{
        val formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss")
        val current = LocalDateTime.now().format(formatter)
        return current
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun convertToLocalDateTimeAndFormat(dateToConvert: Date): String? {
        val localDateTime =  dateToConvert.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime()
        var formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy hh:mm a")
        return localDateTime.format(formatter)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun getLocalDateTime(dateToConvert: Date): LocalDateTime? {
        return dateToConvert.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime()
    }

}