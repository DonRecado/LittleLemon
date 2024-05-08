package com.example.littlelemon.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.littlelemon.database.entities.MenuItem

@Dao
interface MenuItemDao {
    @Query("SELECT * FROM MenuItem")
    fun getAll(): LiveData<List<MenuItem>>

    @Insert
    fun insert(vararg menuItems: MenuItem)

    @Delete
    fun delete(vararg menuItem: MenuItem)

    @Query("SELECT (SELECT COUNT(*) FROM MenuItem) == 0")
    fun isEmpty(): Boolean
}