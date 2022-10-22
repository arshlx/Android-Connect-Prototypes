package com.example.myapplication.model

import com.google.gson.annotations.SerializedName

data class Subject(
    @SerializedName("assignments") val assignments: List<Assignment>,
    @SerializedName("subject_name") val subjectName: String
)