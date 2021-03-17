package com.example.recyclerviewdemo.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Student")
data class StudentEntity (
    @PrimaryKey(autoGenerate = true)
    val id:Int,

    val name:String,

    val programme:String
)