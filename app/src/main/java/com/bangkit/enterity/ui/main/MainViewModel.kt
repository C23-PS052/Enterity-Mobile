package com.bangkit.enterity.ui.main

import android.content.Context
import androidx.lifecycle.ViewModel
import com.bangkit.enterity.rest.GlobalRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainViewModel @Inject constructor(
    private val repository: GlobalRepository,
    private  val context: Context
) : ViewModel(){

    fun getAllProductChannel(token : String) = repository.getAllProductChannel(token)


    fun getAllProduct(token : String) = repository.getAllProduct(token)

    fun getAllPelanggan(token : String) = repository.getAllPelanggan(token)


}