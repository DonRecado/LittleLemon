package com.example.littlelemon.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.littlelemon.database.dao.MenuItemDao
import com.example.littlelemon.database.entities.MenuItem

@Database(entities = [MenuItem::class], version = 1)
abstract class LittleLemonDatabase : RoomDatabase() {
    abstract fun menuItemDao() : MenuItemDao

    companion object {
        private const val DATABASE_NAME = "littlelemon.db"

        @Volatile
        private var INSTANCE: LittleLemonDatabase? = null

        fun getInstance(context: Context): LittleLemonDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        LittleLemonDatabase::class.java,
                        DATABASE_NAME)
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}