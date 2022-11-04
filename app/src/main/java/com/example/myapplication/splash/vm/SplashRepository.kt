package com.example.myapplication.splash.vm

import android.content.Context
import com.example.myapplication.global_objects.TaskStatus
import com.example.myapplication.model.ListOfStudents
import com.example.myapplication.model.Student
import com.example.myapplication.services.APIRemote
import com.example.myapplication.services.RetrofitService
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.FileReader
import java.io.IOException

class SplashRepository {
    private val remote = RetrofitService.getClient()?.create(APIRemote::class.java)

    suspend fun getStudentList(): Pair<String, List<Student>> {
        var studentList = listOf<Student>()
        try {
            val response = remote?.getStudentList()

            if (response != null) {
                studentList = response.body()!!.toList()
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return Pair(TaskStatus.SUCCESS, studentList)
    }

    suspend fun getStudentsFromFile(context: Context): Pair<String, List<Student>> {
        val studentList: ListOfStudents
        try {
            studentList = withContext(Dispatchers.IO) {
                Gson().fromJson(getJsonDataFromAsset(context), ListOfStudents::class.java)
            }
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
        return Pair(TaskStatus.SUCCESS, studentList.stuList)
    }
    private fun getJsonDataFromAsset(context: Context): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open("students.json").bufferedReader().use { it.readText() }
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
        return jsonString
    }
}