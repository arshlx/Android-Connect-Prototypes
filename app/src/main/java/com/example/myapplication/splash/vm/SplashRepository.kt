package com.example.myapplication.splash.vm

import com.example.myapplication.model.Student
import com.example.myapplication.services.APIRemote
import com.example.myapplication.services.RetrofitService

class SplashRepository {
    private val remote = RetrofitService.getClient()?.create(APIRemote::class.java)

    suspend fun getStudentList(): List<Student> {
        var studentList = listOf<Student>()
        try {
            val response = remote?.getStudentList()

            if (response != null) {
                studentList = response.body()!!.toList()
                println("SplashRepo: $studentList")
            }

        }catch (e: Exception) {
            e.printStackTrace()
        }

        return studentList
    }
}