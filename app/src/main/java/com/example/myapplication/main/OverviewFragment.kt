package com.example.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentOverviewBinding
import com.example.myapplication.main.vm.MainViewModel

class OverviewFragment : Fragment() {

    companion object {
        fun newInstance() = OverviewFragment()
    }

    private var _binding: FragmentOverviewBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentOverviewBinding.inflate(inflater, container, false)
        requireActivity().title = getString(R.string.nav_overview)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        return binding.root
    }

    private fun setUpViews() {
        binding.apply {
            nameTxt.text = viewModel.student.name
            schoolTxt.text = viewModel.student.school
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}