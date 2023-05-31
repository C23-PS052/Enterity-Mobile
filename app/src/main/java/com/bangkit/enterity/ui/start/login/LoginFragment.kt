package com.bangkit.enterity.ui.start.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bangkit.enterity.databinding.FragmentLoginBinding
import com.bangkit.enterity.ui.MainActivity


class LoginFragment : Fragment() {

    private lateinit var binding : FragmentLoginBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginBinding.inflate(layoutInflater)

        binding.btLogin.setOnClickListener {
            startActivity(Intent(context, MainActivity::class.java))
        }


        return binding.root
    }


}