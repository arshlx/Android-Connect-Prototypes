package com.example.myapplication.splash.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.global_objects.TaskStatus
import com.example.myapplication.model.Student
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {
    private val repository = SplashRepository()
    val students = mutableListOf<Student>()
    val studentStatus = MutableLiveData(TaskStatus.NONE)

    fun getStudentList() {
        studentStatus.value = TaskStatus.LOADING
        var result = listOf<Student>()
        viewModelScope.launch {
            result = repository.getStudentList()
        }
        students.addAll(result)
        studentStatus.value = if (students.isEmpty()) TaskStatus.EMPTY else TaskStatus.SUCCESS
    }
}