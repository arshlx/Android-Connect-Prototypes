package com.example.myapplication.bottom_sheets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.adapters.StudentAdapter
import com.example.myapplication.databinding.BottomSheetStudentSelectBinding
import com.example.myapplication.model.ListOfStudents
import com.example.myapplication.model.Student
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class StudentSelectBottomSheet(private val students: List<Student>) : BottomSheetDialogFragment() {
    private var _binding: BottomSheetStudentSelectBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetStudentSelectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            studentRecycler.apply {
                scheduleLayoutAnimation()
                adapter = StudentAdapter(this@StudentSelectBottomSheet, ListOfStudents(students))
            }
            closeImg.setOnClickListener { dismiss() }
        }
    }
}