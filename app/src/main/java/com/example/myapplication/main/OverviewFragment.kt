package com.example.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
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
        requireActivity().title = viewModel.selStudent.name
        setUpViews()
        return binding.root
    }

    private fun setUpViews() {
        binding.apply {
//            nameTxt.text = viewModel.selStudent.name
            schoolTxt.text = viewModel.selStudent.school
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}