package com.example.littlelemon.util

import android.content.Context

class PreferenceManager(context: Context) {
    private val sharedPreferences =
        context.getSharedPreferences("LittleLemon", Context.MODE_PRIVATE);

    fun saveString(pair: Pair<String, String>) {
        val editor = sharedPreferences.edit()
        editor.putString(pair.first, pair.second)
        editor.apply()
    }

    fun saveBoolean(pair: Pair<String, Boolean>) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(pair.first, pair.second)
        editor.apply()
    }

    fun saveInt(pair: Pair<String, Int>) {
        val editor = sharedPreferences.edit()
        editor.putInt(pair.first, pair.second)
        editor.apply()
    }

    fun saveLong(pair: Pair<String, Long>) {
        val editor = sharedPreferences.edit()
        editor.putLong(pair.first, pair.second)
        editor.apply()
    }

    fun saveFloat(pair: Pair<String, Float>) {
        val editor = sharedPreferences.edit()
        editor.putFloat(pair.first, pair.second)
        editor.apply()
    }

    fun getString(key: String, default: String): String {
        return sharedPreferences.getString(key, default) ?: default
    }

    fun getBoolean(key: String, default: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, default)
    }

    fun getInt(key: String, default: Int): Int {
        return sharedPreferences.getInt(key, default)
    }
    fun getLong(key: String, default: Long): Long {
        return sharedPreferences.getLong(key, default)
    }

    fun getFloat(key: String, default: Float): Float {
        return sharedPreferences.getFloat(key, default)
    }

    fun clear() {
        sharedPreferences.edit().clear().apply()
    }
}