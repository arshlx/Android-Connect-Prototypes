package com.example.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.myapplication.R
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
            studentImg.setImageResource(
                when (viewModel.selStudent.name) {
                    "James" -> R.drawable.stu_3
                    "Jennifer" -> R.drawable.stu_1
                    else -> R.drawable.stu_2
                }
            )
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
        }
        setUpShowcase()
    }

    private fun setUpShowcase(){
        binding.apply {
            sub1.apply {
                numAssnTxt.text = "2"
                assn1.root.text = getString(R.string.sw_8)
                assn2.root.text = getString(R.string.sw_1)
                assn3.root.visibility = View.GONE
            }
            sub2.apply {
                subjectTxt.text = getString(R.string.math)
                numAssnTxt.text = "3"
                assn1.root.text = getString(R.string.sw_2)
                assn2.root.text = getString(R.string.sw_3)
                assn3.root.text = getString(R.string.sw_4)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}