package com.example.myapplication.main

import android.os.Bundle
import android.widget.Toast
import android.window.OnBackInvokedDispatcher
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.PositionInterface
import com.example.myapplication.R
import com.example.myapplication.adapters.FragmentPagerAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.global_objects.Constants
import com.example.myapplication.main.vm.MainViewModel
import com.example.myapplication.model.ListOfStudents
import com.example.myapplication.model.Student
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), PositionInterface {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModels()
    private var exit = false
    private lateinit var toast: Toast
    private lateinit var pagerAdapter: FragmentPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.apply {
            selStudent =
                Gson().fromJson(intent.getStringExtra(Constants.STUDENT), Student::class.java)
            studentList = Gson().fromJson(
                intent.getStringExtra(Constants.STU_LIST), ListOfStudents::class.java
            ).stuList
            setUpBottomNav()
        }
        toast = Toast.makeText(this, R.string.exit_warning, Toast.LENGTH_LONG)
    }

    override fun getOnBackInvokedDispatcher(): OnBackInvokedDispatcher {
        binding.fragmentPager.apply {
            when (currentItem) {
                0 -> exitApp()
                else -> currentItem = 0
            }
        }
        return super.getOnBackInvokedDispatcher()
    }

    override fun onDestroy() {
        super.onDestroy()
        toast.cancel()
    }

    private fun exitApp() {
        if (exit) finish() else
            CoroutineScope(Dispatchers.Main).launch {
                exit = true
                toast.show()
                delay(2000)
                exit = false
            }
    }

    private fun setUpBottomNav() {
        pagerAdapter = FragmentPagerAdapter(supportFragmentManager, lifecycle, this)
        binding.apply {
            fragmentPager.apply {
                adapter = pagerAdapter
                currentItem = Constants.NAV_OVERVIEW
            }
            bottomNav.apply {
                setOnItemSelectedListener {
                    fragmentPager.currentItem = when (it.itemId) {
                        R.id.nav_preferences -> {
                            title = getString(R.string.nav_preferences)
                            Constants.NAV_PREFERENCES
                        }
                        R.id.nav_assignments -> {
                            title = getString(R.string.nav_preferences)
                            Constants.NAV_ASSIGNMENTS
                        }
                        else -> {
                            title = getString(R.string.nav_preferences)
                            Constants.NAV_OVERVIEW
                        }
                    }
                    true
                }
            }
        }
    }

    override fun onPositionChanged(position: Int) {
        binding.bottomNav.selectedItemId = position
    }

}
