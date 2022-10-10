package com.example.myapplication.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            idEdt.apply {
                setOnFocusChangeListener { _, _ -> resetErrors() }
                doOnTextChanged { _, _, _, _ -> enableLoginBtn() }
            }
            passwordEdt.apply {
                setOnFocusChangeListener { _, _ -> resetErrors() }
                doOnTextChanged { _, _, _, _ -> enableLoginBtn() }
            }
            loginBtn.setOnClickListener {
                if (!idEdt.text.isNullOrEmpty() && !passwordEdt.text.isNullOrEmpty()) {
                    when {
                        idEdt.text.toString().trim()
                            .equals(getString(R.string.id), false) && passwordEdt.text.toString()
                            .trim().equals(getString(R.string.pass), false) -> {
                            parentFragmentManager.beginTransaction().apply {
                                replace(R.id.container, StudentsFragment.newInstance())
                                commit()
                            }
                        }
                        else -> Toast.makeText(
                            requireContext(), R.string.incorrect_id_password, Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
    }


    private fun resetErrors() {
        binding.apply {
            idEdt.error = null
            passwordEdt.error = null
        }
    }

    private fun enableLoginBtn() {
        binding.apply {
            loginBtn.isEnabled = !idEdt.text.isNullOrEmpty() && !passwordEdt.text.isNullOrEmpty()
        }
    }
}


/*
else -> {
    idEdt.error = getString(R.string.id_cannot_be_empty)
    passwordEdt.error = getString(R.string.password_cannot_be_empty)
}*/