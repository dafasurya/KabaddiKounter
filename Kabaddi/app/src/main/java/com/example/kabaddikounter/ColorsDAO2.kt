package com.example.kabaddikounter

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ColorsDAO2 {

    @Query("SELECT * FROM Colors2")
    suspend fun getAll():Array<Colors2>

    @Insert
    suspend fun insert(colors: Colors2)

    @Update
    suspend fun update(colors: Colors2)

    @Delete
    suspend fun delete(colors: Colors2)

}