package com.example.baru

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "colors")
data class Colors(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name = "hex_colors")val hex: String,
    val name:String
)