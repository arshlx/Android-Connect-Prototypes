package com.example.myapplication.appointments

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.myapplication.appointments.vm.AppointmentsViewModel
import com.example.myapplication.databinding.ActivityAppointmentsBinding
import com.example.myapplication.global_objects.TaskStatus

class AppointmentsActivity : AppCompatActivity() {

    private var _binding: ActivityAppointmentsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AppointmentsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAppointmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        viewModel.apply {
//            listStatus.observe(this@AppointmentsActivity, appointmentObserver)
//            initAppointments()
//        }
    }

    private val appointmentObserver = Observer<String> {
        when (it) {
            TaskStatus.LOADING -> {
                binding.progressBar.visibility = View.VISIBLE
            }
            TaskStatus.SUCCESS -> {
                binding.apply {
                    progressBar.visibility = View.GONE

                }
            }
        }
    }
}