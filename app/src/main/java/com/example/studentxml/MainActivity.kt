package com.example.studentxml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var students: ArrayList<Students>
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        try {
            val parser = XMLParser()
            val inputStream = assets.open("student.xml")
            students = parser.parse(inputStream)

            recyclerView.adapter = RecyclerViewAdapter(students)
            recyclerView.layoutManager = LinearLayoutManager(this)
        }catch (e: IOException){
            println("issue: $e")
        }

    }
}