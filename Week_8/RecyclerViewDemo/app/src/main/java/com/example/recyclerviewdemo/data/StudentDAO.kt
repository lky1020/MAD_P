package com.example.recyclerviewdemo.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDAO {
    @Insert
    suspend fun addStudent(stud: StudentEntity)

    @Query("SELECT * FROM Student")
    fun getAllStudent(): ArrayList<StudentEntity>
}