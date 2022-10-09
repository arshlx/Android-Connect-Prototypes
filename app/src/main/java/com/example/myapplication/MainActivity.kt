package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
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
