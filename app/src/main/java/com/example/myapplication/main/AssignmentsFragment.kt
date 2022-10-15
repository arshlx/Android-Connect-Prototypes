package com.example.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.myapplication.R
import com.example.myapplication.adapters.AssignmentAdapter
import com.example.myapplication.databinding.FragmentAssignmentsBinding
import com.example.myapplication.main.vm.MainViewModel
import com.example.myapplication.model.Assignment

class AssignmentsFragment : Fragment() {

    var assnList = mutableListOf<Assignment>()

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
        requireActivity().title = getString(R.string.nav_assignments)
        initList()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.assnRecycler.adapter =
            AssignmentAdapter(viewModel.selStudent.assignments.toMutableList())
    }

    private fun initList() {
        assnList.apply {
            add(
                Assignment(
                    "1",
                    "Essay Writing",
                    false,
                    "10/09/2022",
                    "25/09/2022",
                    "500 words essay on IoT"
                )
            )
            add(
                Assignment(
                    "2",
                    "Math Questions",
                    false,
                    "13/09/2022",
                    "28/09/2022",
                    "Quizzs"
                )
            )
            add(
                Assignment(
                    "3",
                    "Physics Assignment",
                    true,
                    "10/09/2022",
                    "10/10/2022",
                    "Tutorials"
                )
            )
            add(
                Assignment(
                    "4",
                    "Essay Writing",
                    false,
                    "10/09/2022",
                    "25/09/2022",
                    "500 words essay on IoT"
                )
            )
            add(
                Assignment(
                    "5",
                    "Essay Writing",
                    false,
                    "10/09/2022",
                    "25/09/2022",
                    "500 words essay on IoT"
                )
            )
            add(
                Assignment(
                    "6",
                    "Essay Writing",
                    true,
                    "10/09/2022",
                    "25/09/2022",
                    "500 words essay on IoT"
                )
            )
            add(
                Assignment(
                    "7",
                    "Essay Writing",
                    false,
                    "10/09/2022",
                    "25/09/2022",
                    "500 words essay on IoT"
                )
            )
            add(
                Assignment(
                    "8",
                    "Essay Writing",
                    true,
                    "10/09/2022",
                    "25/09/2022",
                    "500 words essay on IoT"
                )
            )
            add(
                Assignment(
                    "9",
                    "Essay Writing",
                    false,
                    "10/09/2022",
                    "25/09/2022",
                    "500 words essay on IoT"
                )
            )
            add(
                Assignment(
                    "10",
                    "Essay Writing",
                    false,
                    "10/09/2022",
                    "25/09/2022",
                    "500 words essay on IoT"
                )
            )
            add(
                Assignment(
                    "11",
                    "Essay Writing",
                    false,
                    "10/09/2022",
                    "25/09/2022",
                    "500 words essay on IoT"
                )
            )
            add(
                Assignment(
                    "12",
                    "Essay Writing",
                    false,
                    "10/09/2022",
                    "25/09/2022",
                    "500 words essay on IoT"
                )
            )
            add(
                Assignment(
                    "13",
                    "Essay Writing",
                    false,
                    "10/09/2022",
                    "25/09/2022",
                    "500 words essay on IoT"
                )
            )
            add(
                Assignment(
                    "14",
                    "Essay Writing",
                    false,
                    "10/09/2022",
                    "25/09/2022",
                    "500 words essay on IoT"
                )
            )

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}