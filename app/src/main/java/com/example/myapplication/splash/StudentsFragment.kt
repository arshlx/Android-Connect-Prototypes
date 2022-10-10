package com.example.myapplication.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentStudentsBinding
import com.example.myapplication.global_objects.TaskStatus
import com.example.myapplication.splash.vm.SplashViewModel

class StudentsFragment : Fragment() {
    companion object {
        @JvmStatic
        fun newInstance() = StudentsFragment()
    }

    private var _binding: FragmentStudentsBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: SplashViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStudentsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[SplashViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.studentStatus.observe(viewLifecycleOwner, studentObserver)
        viewModel.getStudentList()
    }

    private val studentObserver = Observer<String> {
        when (it) {
            TaskStatus.LOADING -> {}
            TaskStatus.SUCCESS -> {}
            TaskStatus.EMPTY -> {}
        }
    }
}