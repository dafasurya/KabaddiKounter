package com.example.kabaddikounter

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "colors3")
data class Colors3(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name = "hex_colors")val hex: String,
    val name:String
)
