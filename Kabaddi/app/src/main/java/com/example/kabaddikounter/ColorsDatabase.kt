package com.example.kabaddikounter

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.baru.Colors
import com.example.baru.ColorsDao

@Database(entities = [Colors::class], version = 1)
abstract class ColorsDatabase : RoomDatabase() {

    abstract fun colorsDao(): ColorsDao

    companion object {
        @Volatile
        private var INSTANCE: ColorsDatabase? = null

        fun getInstance(context: Context): ColorsDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    ColorsDatabase::class.java, "color_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }

        }

    }
}