package com.example.myapplication.main.vm

import androidx.lifecycle.ViewModel
import com.example.myapplication.model.Student

class MainViewModel : ViewModel() {
    lateinit var studentList: List<Student>
    lateinit var selStudent: Student
}