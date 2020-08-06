package com.nullbyte.personalledger.utilities

import android.content.Context
import android.content.SharedPreferences

object SharedPrefUtility {
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context?) {
            sharedPreferences = context?.getSharedPreferences(Constant.PREFERENCES, Context.MODE_PRIVATE)!!
    }

    fun getString(key: String?): String? {
        return sharedPreferences.getString(key, "")
    }

    fun setString(key: String?, value: String?) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getDouble(key: String?): Double? {
        return java.lang.Double.longBitsToDouble(
            sharedPreferences.getLong(
                key,
                java.lang.Double.doubleToLongBits(0.0)
            )
        )
    }

    fun setDouble(key: String?, value: Double?) {
        val editor = sharedPreferences.edit()
        editor.putLong(key, java.lang.Double.doubleToRawLongBits(value!!))
        editor.apply()
    }

    fun getLong(key: String?): Long? {
        return sharedPreferences.getLong(key, 0)
    }

    fun setLong(key: String?, value: Long?) {
        val editor = sharedPreferences.edit()
        editor.putLong(key, value!!)
        editor.apply()
    }

    fun getBoolean(key: String?): Boolean? {
        return sharedPreferences.getBoolean(key, false)
    }

    fun setBoolean(key: String?, value: Boolean?) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(key, value!!)
        editor.apply()
    }
}

//object SharedPrefUtility {
//    private const val NAME = Constant.PREFERENCES
//    private const val MODE = Context.MODE_PRIVATE
//    private lateinit var preferences: SharedPreferences
//
//    // App specific references
//    private val IS_LOGGED_IN = Pair("IsLoggedIn", false)
//
//    fun init(context: Context) {
//        preferences = context.getSharedPreferences(NAME, MODE)
//    }
//
//    /**
//     * SharedPreferences extension function, so we won't need to call edit() and apply()
//     * ourselves on every SharedPreferences operation.
//     */
//    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
//        val editor = edit()
//        operation(editor)
//        editor.apply()
//    }
//
//    var isLoggedIn: Boolean
//        // custom getter to get a preference of a desired type, with a predefined default value
//        get() = preferences.getBoolean(IS_LOGGED_IN.first, IS_LOGGED_IN.second)
//        // custom setter to save a preference back to preferences file
//        set(value) = preferences.edit {
//            it.putBoolean(IS_LOGGED_IN.first, value)
//        }
//}