package com.example.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.adapters.SubjectsAdapter
import com.example.myapplication.databinding.FragmentOverviewBinding
import com.example.myapplication.main.vm.MainViewModel

class OverviewFragment : Fragment() {

    companion object {
        fun newInstance() = OverviewFragment()
    }

    private var _binding: FragmentOverviewBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOverviewBinding.inflate(inflater, container, false)
        setUpViews()
        return binding.root
    }

    private fun setUpViews() {
        binding.apply {
            nameTxt.text = viewModel.selStudent.name
            schoolTxt.text = viewModel.selStudent.school
            Glide.with(requireContext()).load(viewModel.selStudent.url).into(studentImg)
            gradeTxt.apply {
                visibility = View.VISIBLE
                text = getString(R.string.grade_str, viewModel.selStudent.grade)
            }
            attendanceTxt.apply {
                val attendance =
                    (100 * viewModel.selStudent.attendedDays / viewModel.selStudent.totalDays).toString() + "%"
                visibility = View.VISIBLE
                text = getString(R.string.attendance_str, attendance)
            }
            subjectRecycler.adapter =
                SubjectsAdapter(this@OverviewFragment, viewModel.selStudent.subjects)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}