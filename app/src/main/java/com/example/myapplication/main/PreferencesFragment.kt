package com.example.myapplication.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapters.PreferencesAdapter
import com.example.myapplication.bottom_sheets.YesNoBottomSheet
import com.example.myapplication.databinding.FragmentPreferencesBinding
import com.example.myapplication.global_objects.Constants
import com.example.myapplication.ingterfaces.TagPositionInterface
import com.example.myapplication.splash.SplashActivity

class PreferencesFragment : Fragment(), TagPositionInterface {

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
        binding.prefsRecycler.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = PreferencesAdapter(this@PreferencesFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(tag: String, position: Int) {
        when (tag) {
            Constants.PREFERENCE -> {
                when (position) {
                    0 -> {}
                    1 -> {}
                    2 -> {}
                    3 -> {}
                    4 -> {}
                    else -> {
                        YesNoBottomSheet(
                            this,
                            getString(R.string.log_out),
                            getString(R.string.logout_warning),
                            getString(R.string.cancel),
                            getString(R.string.log_out)
                        ).show(parentFragmentManager, "")
                    }
                }
            }
            else -> {
                if (position == 1) {
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
        }
    }
}