package com.example.myapplication.model

import com.google.gson.annotations.SerializedName

data class ListOfAppointments(@SerializedName("appointments") val appointments: MutableList<Appointment>)