package com.bangkit.enterity.ui.start.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bangkit.enterity.R
import com.bangkit.enterity.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSplashBinding.inflate(layoutInflater)
        lifecycleScope.launch {
            delay(delayTime)
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        }


        return binding.root
    }

    companion object {
        const val delayTime = 1500L
    }


}