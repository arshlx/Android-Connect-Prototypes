package com.example.myapplication.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.global_objects.Constants
import com.example.myapplication.main.vm.MainViewModel
import com.example.myapplication.model.Student
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.student =
            Gson().fromJson(intent.getStringExtra(Constants.STUDENT), Student::class.java)
        setUpBottomNav()
    }

    private fun setUpBottomNav() {
        setActiveFragment(OverviewFragment.newInstance())
        binding.bottomNav.apply {
            setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.nav_preferences -> setActiveFragment(PreferencesFragment.newInstance())
                    R.id.nav_assignments -> setActiveFragment(AssignmentsFragment.newInstance())
                    else -> setActiveFragment(OverviewFragment.newInstance())
                }
                true
            }
        }
    }

    private fun setActiveFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(binding.container.id, fragment)
            commit()
        }

}
