package com.example.myapplication.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivitySplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private var _binding: ActivitySplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = getString(R.string.connect_plus)
        showHideProgressBar()
    }

    private fun showHideProgressBar() {
        CoroutineScope(Dispatchers.Main).launch {
            binding.progressBar.apply {
                visibility = View.VISIBLE
                delay(2000)
                visibility = View.GONE
                supportFragmentManager.beginTransaction().apply {
                    replace(binding.container.id, LoginFragment.newInstance())
                    commit()
                }
            }
        }

    }
}