package com.example.myapplication.main

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
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
        binding.sendEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:") // only email apps should handle this
                putExtra(Intent.EXTRA_EMAIL, "arshdeep100@gmail.com")
            }
            try {
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(this, R.string.application_not_found, Toast.LENGTH_LONG).show()
            }
        }
    }


    override fun onBackPressed() {
        super.onBackPressed()
        binding.fragmentPager.apply {
            when (currentItem) {
                0 -> exitApp()
                else -> currentItem = 0
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        toast.cancel()
    }

    private fun exitApp() {
        if (exit) finish() else
            CoroutineScope(Dispatchers.IO).launch {
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
                registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        bottomNav.selectedItemId = when (position) {
                            0 -> R.id.nav_overview
                            1 -> R.id.nav_assignments
                            else -> R.id.nav_preferences
                        }
                        super.onPageSelected(position)
                    }
                })
            }
            bottomNav.apply {
                setOnItemSelectedListener {
                    fragmentPager.currentItem = when (it.itemId) {
                        R.id.nav_preferences -> {
                            title = getString(R.string.nav_preferences)
                            binding.sendEmail.hide()
                            Constants.NAV_PREFERENCES
                        }
                        R.id.nav_assignments -> {
                            title = getString(R.string.nav_assignments)
                            binding.sendEmail.hide()
                            Constants.NAV_ASSIGNMENTS
                        }
                        else -> {
                            title = getString(R.string.nav_overview)
                            binding.sendEmail.show()
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
