package com.example.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdemo.data.StudentDB
import com.example.recyclerviewdemo.data.StudentEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var recList: Array<StudentEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd: Button = findViewById(R.id.btn_Add)

        btnAdd.setOnClickListener(){
            val student1: StudentEntity = StudentEntity(0, "John", "RSF")

            val studDao = StudentDB.getDatabase(applicationContext).studentDAO()

            CoroutineScope(IO).launch {
                studDao.addStudent(student1)
            }
        }

        val btnGet: Button = findViewById(R.id.btn_Get)
        btnGet.setOnClickListener {
            var studentList = ArrayList<Student>()
            val studDao = StudentDB.getDatabase(applicationContext).studentDAO()

            CoroutineScope(Main).launch {
                recList = studDao.getAll()

                for(i in recList){
                    studentList.add(Student(R.drawable.ic_android, i.name, i.programme))
                }

                val recyclerView: RecyclerView = findViewById(R.id.rv_Student)

                recyclerView.adapter = StudentAdapter(studentList)
                recyclerView.layoutManager = LinearLayoutManager(application)
                recyclerView.setHasFixedSize(true)

            }
        }
    }
}