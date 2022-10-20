package com.example.myapplication.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.myapplication.databinding.ActivityAssignmentDetailBinding
import com.example.myapplication.global_objects.Constants
import com.example.myapplication.model.Assignment
import com.google.gson.Gson

class AssignmentDetailActivity : AppCompatActivity() {

    private var _binding: ActivityAssignmentDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var assn: Assignment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAssignmentDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        assn = Gson().fromJson(intent.getStringExtra(Constants.ASSIGNMENT), Assignment::class.java)
        binding.apply {
            subjectTxt.text = assn.subject
            assnNameTxt.text = assn.name
            dueDateTxt.text = assn.dueDate
            descriptionTxt.text = assn.desc
            groupLayout.isVisible = assn.isGroup
            viewAssnBtn
        }
    }
}