package com.example.myapplication.model

import com.google.gson.annotations.SerializedName

data class Assignment(
    val id: String,
    @SerializedName("assignment_name") val name: String,
    @SerializedName("group_assignment") val isGroup: Boolean = false,
    val startDate: String,
    @SerializedName("subject") val subject: String,
    @SerializedName("assignment_duedate") val dueDate: String,
    @SerializedName("assignment_description")val desc: String
)