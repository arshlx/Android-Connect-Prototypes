package com.example.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentDiscussionBinding

class DiscussionFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = DiscussionFragment()
    }

    private var _binding: FragmentDiscussionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDiscussionBinding.inflate(inflater, container, false)
        return binding.root
    }


}