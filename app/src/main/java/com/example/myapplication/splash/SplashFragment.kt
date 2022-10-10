package com.example.myapplication.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = SplashFragment()
    }

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showHideProgressBar()
    }

    private fun showHideProgressBar() {
        CoroutineScope(Dispatchers.Main).launch {
            binding.progressBar.apply {
                visibility = View.VISIBLE
                delay(2000)
                visibility = View.GONE
                parentFragmentManager.beginTransaction().apply {
                    replace(binding.container.id, LoginFragment.newInstance())
                    commit()
                }
            }
        }
    }
}