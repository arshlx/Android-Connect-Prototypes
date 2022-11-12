package com.example.myapplication.appointments.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.global_objects.TaskStatus
import com.example.myapplication.model.Appointment
import kotlinx.coroutines.launch

class AppointmentsViewModel : ViewModel() {
    val repository = AppointmentsRepository()
    var appointments = mutableListOf<Appointment>()
    val listStatus = MutableLiveData(TaskStatus.NONE)

    fun initAppointments() {
        listStatus.value = TaskStatus.LOADING
        viewModelScope.launch {
            val result = repository.getAppointments()
            appointments = result.first
            listStatus.value = result.second
        }
    }
}