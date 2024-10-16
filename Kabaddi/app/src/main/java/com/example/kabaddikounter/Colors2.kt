package com.example.kabaddikounter

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "colors2")
data class Colors2(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name = "hex_colors")val hex: String,
    val name:String
)
