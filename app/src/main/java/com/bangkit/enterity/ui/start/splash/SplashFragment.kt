package com.bangkit.enterity.ui.start.splash

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import com.bangkit.enterity.R
import com.bangkit.enterity.databinding.FragmentSplashBinding
import com.bangkit.enterity.ui.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSplashBinding.inflate(layoutInflater)
        getStatusLogin()
        lifecycleScope.launch {
            delay(delayTime)
            getStatusLogin()
        }


        return binding.root
    }

    private fun getStatusLogin() {
        val pref = PreferenceManager.getDefaultSharedPreferences(requireContext())
        val isLogin = pref.getBoolean(getString(R.string.isLogin), false)
        Log.d(ContentValues.TAG, "statusnya: $isLogin")
        if (isLogin) {
            startActivity(Intent(context, MainActivity::class.java))
            activity?.finish()
        }else{
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        }
    }

    companion object {
        const val delayTime = 1500L
    }


}