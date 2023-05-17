package com.baladroid.baseapp.domain.sharedpref

import android.content.Context
import android.content.SharedPreferences

class PreferenceRepository(val context: Context) {

    val pref: SharedPreferences = context.getSharedPreferences(PrefConstants.PREFERENCE_NAME, Context.MODE_PRIVATE)
    private val editor = pref.edit()

    fun setUserLoggedId(isLoggedIn: Boolean) {
        PrefConstants.PREF_IS_LOGGED_IN.put(isLoggedIn)
    }

    fun isUserLoggedId() = PrefConstants.PREF_IS_LOGGED_IN


    fun clearData() {
        editor.clear()
        editor.commit()
    }

    private fun String.put(long: Long) {
        editor.putLong(this, long)
        editor.commit()
    }

    private fun String.put(int: Int) {
        editor.putInt(this, int)
        editor.commit()
    }

    private fun String.put(string: String) {
        editor.putString(this, string)
        editor.commit()
    }

    private fun String.put(boolean: Boolean) {
        editor.putBoolean(this, boolean)
        editor.commit()
    }

    private fun String.getLong() = pref.getLong(this, 0)

    private fun String.getInt() = pref.getInt(this, 0)

    private fun String.getString() = pref.getString(this, "")!!

    private fun String.getBoolean() = pref.getBoolean(this, false)
}