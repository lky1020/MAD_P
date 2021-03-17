package com.example.recyclerviewdemo.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.recyclerviewdemo.data.StudentEntity

@Dao
interface StudentDAO {

    @Insert
    suspend fun addStudent(s: StudentEntity)

    @Query("Select * from Student")
    fun getAll(): Array<StudentEntity>
}