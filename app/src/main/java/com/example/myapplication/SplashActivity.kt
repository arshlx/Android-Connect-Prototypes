package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivitySplashBinding
import kotlinx.coroutines.*

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private var _binding: ActivitySplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showHideProgressBar()
    }

    private fun showHideProgressBar() {
        CoroutineScope(Dispatchers.Main).launch{
            binding.progressBar.apply {
                visibility = View.VISIBLE
                delay(2500)
                visibility = View.GONE
                finish()
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            }
        }

    }
}