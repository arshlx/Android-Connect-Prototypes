package com.example.myapplication.model

import com.google.gson.annotations.SerializedName

data class Assignment(
    val id: String,
    @SerializedName("assignment_name") val name: String,
    @SerializedName("group_assignment") val isGroup: Boolean = false,
    val startDate: String,
    @SerializedName("assignment_duedate") val dueDate: String,
    val desc: String
)