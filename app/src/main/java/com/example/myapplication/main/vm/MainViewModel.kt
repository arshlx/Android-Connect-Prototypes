package com.example.myapplication.main.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.global_objects.TaskStatus
import com.example.myapplication.model.Assignment
import com.example.myapplication.model.Student
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class MainViewModel : ViewModel() {
    lateinit var studentList: List<Student>
    lateinit var selStudent: Student
    private val dateFormat = SimpleDateFormat("mm-dd-yyyy", Locale("us"))
    val assignmentList = mutableListOf<Assignment>()
    val listStatus = MutableLiveData(TaskStatus.NONE)

    fun setUpAssnList() {
        listStatus.value = TaskStatus.LOADING
        viewModelScope.launch {
            studentList.forEach { it ->
                it.subjects.forEach { subject ->
                    subject.apply {
                        assignments.forEach {
                            it.date = dateFormat.parse(it.dueDate)!!
                        }
                    }
                    assignmentList.addAll(subject.assignments)
                }
                if (it == studentList.last()) {
                    listStatus.value = TaskStatus.SUCCESS
                }
            }

        }
    }
}