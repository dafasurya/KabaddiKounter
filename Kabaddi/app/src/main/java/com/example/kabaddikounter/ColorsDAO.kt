package com.example.baru

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ColorsDao {

    @Query("SELECT * FROM Colors")
    suspend fun getAll():Array<Colors>

    @Insert
    suspend fun insert(colors: Colors)

    @Update
    suspend fun update(colors: Colors)

    @Delete
    suspend fun delete(colors: Colors)

}