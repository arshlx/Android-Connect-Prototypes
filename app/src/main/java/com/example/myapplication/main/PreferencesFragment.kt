package com.example.myapplication.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentPreferencesBinding
import com.example.myapplication.global_objects.Constants
import com.example.myapplication.splash.SplashActivity

class PreferencesFragment : Fragment() {

    companion object {
        fun newInstance() = PreferencesFragment()
    }

    private var _binding: FragmentPreferencesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPreferencesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.logoutBtn.setOnClickListener {
            requireActivity().apply {
                getSharedPreferences(Constants.LOGIN, Context.MODE_PRIVATE).edit()
                    .putBoolean(Constants.LOGGED_IN, false).apply()
                finish()
            }
            startActivity(
                Intent(
                    requireContext(), SplashActivity::class.java
                ).putExtra(Constants.LOGGED_IN, false)
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}