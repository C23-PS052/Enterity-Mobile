package com.bangkit.enterity.ui.start.login

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import com.bangkit.enterity.R
import com.bangkit.enterity.databinding.FragmentLoginBinding
import com.bangkit.enterity.di.Injectable
import com.bangkit.enterity.model.ResultCustom
import com.bangkit.enterity.ui.MainActivity
import com.bangkit.enterity.ui.start.StartViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


class LoginFragment : Fragment(), Injectable {

    private lateinit var binding : FragmentLoginBinding

    @Inject
    lateinit var viewModel : StartViewModel




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginBinding.inflate(layoutInflater)

        binding.btLogin.setOnClickListener {
//            startActivity(Intent(context, MainActivity::class.java))
            authUser()


        }

        binding.tvDaftar.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }


        return binding.root
    }

    private fun authUser() {
        val email = binding.edLoginEmail.text.toString()
        val password = binding.edLoginPassword.text.toString()
        if (email.isNotEmpty() && password.isNotEmpty()){

            viewModel.loginUser( email, password).observe(viewLifecycleOwner){result ->
                when(result){
                    is ResultCustom.Loading ->{
                        binding.prgBar.visibility = View.VISIBLE
                    }
                    is ResultCustom.Error -> {
                        binding.prgBar.visibility = View.GONE
                    }
                    is ResultCustom.Success -> {
                        Toast.makeText(context, "Berhasil", Toast.LENGTH_SHORT).show()
                        binding.prgBar.visibility = View.GONE
                        changeStatus(result.data.accessToken)
                        lifecycleScope.launch {
                            delay(3000)
                            startActivity(Intent(context, MainActivity::class.java))
                            activity?.finishAffinity()

                        }
                    }
                }


            }

        }else{
            when{

                email.isEmpty() -> {
                    setTextError("Email Tidak Boleh Kosong",binding.edLoginEmail)
                }
                password.isEmpty() -> {
                    setTextError("Password Tidak Boleh Kosong",binding.edLoginPassword)
                }
            }
        }
    }

    private fun changeStatus(accessToken: String) {
        val pref = PreferenceManager.getDefaultSharedPreferences(requireContext())
        val editor = pref.edit()
        editor.putBoolean(getString(R.string.isLogin), true)
        editor.putString(getString(R.string.token), accessToken)
        editor.apply()
        val token = pref.getString(context?.getString(R.string.token), "")
        Log.d(ContentValues.TAG, "bindtoken1: $token")
        Log.d(ContentValues.TAG, "bindtoken2: $accessToken")
//        val isLogin = pref.getBoolean(getString(R.string.isLogin), false)
//        Log.d(ContentValues.TAG, "statusnyaa: $isLogin")
    }

    private fun setTextError(msg: String, editText: EditText?) {
        editText?.error = msg
        editText?.requestFocus()
        editText?.findFocus()
    }


}