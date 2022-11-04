package com.example.myapplication.model

import com.google.gson.annotations.SerializedName

data class ListOfStudents (@SerializedName("students") val stuList: List<Student>)