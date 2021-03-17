package com.example.recyclerviewdemo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.recyclerviewdemo.data.StudentDAO
import com.example.recyclerviewdemo.data.StudentEntity

@Database(entities = [StudentEntity::class], version = 1, exportSchema = false)
abstract class StudentDB: RoomDatabase() {
    abstract fun studentDAO(): StudentDAO

    companion object{
        private var INSTANCE : StudentDB? = null

        fun getDatabase(context: Context): StudentDB{
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        StudentDB::class.java,
                        "student_database"
                    ).fallbackToDestructiveMigration().build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}