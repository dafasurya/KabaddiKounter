package com.example.kabaddikounter

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ColorsDAO3 {

    @Query("SELECT * FROM colors3")
    suspend fun getAll():Array<Colors3>

    @Insert
    suspend fun insert(colors: Colors3)

    @Update
    suspend fun update(colors: Colors3)

    @Delete
    suspend fun delete(colors: Colors3)

}