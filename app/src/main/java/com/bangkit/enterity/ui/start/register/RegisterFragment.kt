package com.bangkit.enterity.ui.start.register

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bangkit.enterity.R
import com.bangkit.enterity.databinding.FragmentRegisterBinding
import com.bangkit.enterity.di.Injectable
import com.bangkit.enterity.model.ResultCustom
import com.bangkit.enterity.ui.start.StartViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


class RegisterFragment : Fragment(), Injectable {

    private lateinit var binding : FragmentRegisterBinding

    @Inject
    lateinit var viewModel : StartViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(layoutInflater)

        binding.btLogin.setOnClickListener {
            registerUser()
        }


        return binding.root
    }

    private fun registerUser() {
        val namaToko = binding.edStore.text.toString()
        val email = binding.edLoginEmail.text.toString()
        val password = binding.edLoginPassword.text.toString()
        if (namaToko.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()){

            viewModel.registerUser(namaToko, email, password).observe(viewLifecycleOwner){result ->
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
                        lifecycleScope.launch {
                            delay(3000)
                            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)

                        }
                    }
                }


            }

        }else{
            when{
                namaToko.isEmpty() -> {
                    setTextError("Nama Toko Tidak Boleh Kosong",binding.edStore)
                }
                email.isEmpty() -> {
                    setTextError("Email Tidak Boleh Kosong",binding.edLoginEmail)
                }
                password.isEmpty() -> {
                    setTextError("Password Tidak Boleh Kosong",binding.edLoginPassword)
                }
            }
        }
    }
    private fun setTextError(msg: String, editText: EditText?) {
        editText?.error = msg
        editText?.requestFocus()
        editText?.findFocus()
    }


}