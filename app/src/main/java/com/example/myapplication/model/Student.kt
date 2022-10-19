package com.example.myapplication.model

import com.google.gson.annotations.SerializedName

data class Student(
    @SerializedName("student_name") val name: String,
    @SerializedName("school_name") val school: String,
    @SerializedName("assignments") val assignments: List<Assignment>,
    @SerializedName("total_days") val totalDays: Int,
    @SerializedName("total_attendence_days") val attendedDays: Int
)