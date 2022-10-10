package com.example.myapplication.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.global_objects.Constants
import com.example.myapplication.databinding.ItemStudentBinding
import com.example.myapplication.main.MainActivity
import com.example.myapplication.model.Student
import com.google.gson.Gson

class StudentAdapter(private val fragment: Fragment, private val studentList: List<Student>) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    inner class StudentViewHolder(private val binding: ItemStudentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(student: Student) {
            binding.root.setOnClickListener {
                fragment.apply {
                    requireActivity().finish()
                    startActivity(
                        Intent(requireActivity(), MainActivity::class.java).putExtra(
                            Constants.STUDENT,
                            Gson().toJson(student)
                        )
                    )
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        return StudentViewHolder(
            ItemStudentBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(studentList[position])
    }

    override fun getItemCount() = studentList.size
}