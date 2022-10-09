package com.example.myapplication.model

data class Assignment(
    val id: String,
    val name: String,
    val isGroup: Boolean = false,
    val startDate: String,
    val dueDate: String,
    val desc: String
)