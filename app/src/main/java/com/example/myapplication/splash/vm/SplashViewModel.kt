package com.example.myapplication.splash.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.global_objects.TaskStatus
import com.example.myapplication.model.ListOfStudents
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {
    private val repository = SplashRepository()
    lateinit var students: ListOfStudents
    var loggedIn = false
    val studentStatus = MutableLiveData(TaskStatus.NONE)

    fun getStudentList() {
        studentStatus.value = TaskStatus.LOADING
        viewModelScope.launch {
            val result = repository.getStudentList()
            students = ListOfStudents(result.second)
            studentStatus.value = result.first
        }
    }
}