package com.example.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.myapplication.adapters.AssignmentAdapter
import com.example.myapplication.databinding.FragmentAssignmentsBinding
import com.example.myapplication.main.vm.MainViewModel
import com.example.myapplication.model.Assignment

class AssignmentsFragment : Fragment() {

    companion object {
        fun newInstance() = AssignmentsFragment()
    }

    private var _binding: FragmentAssignmentsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAssignmentsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.assnRecycler.adapter =
            AssignmentAdapter(requireContext(), viewModel.selStudent.assignments)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}