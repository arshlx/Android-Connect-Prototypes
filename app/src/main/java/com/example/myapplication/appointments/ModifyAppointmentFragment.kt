package com.example.myapplication.appointments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R

class ModifyAppointmentFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = ModifyAppointmentFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_modify_appointment, container, false)
    }

}