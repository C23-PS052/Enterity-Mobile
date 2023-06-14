package com.bangkit.enterity.rest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.bangkit.enterity.model.ResponseLogin
import com.bangkit.enterity.model.ResponseRegister
import com.bangkit.enterity.model.ResultCustom
import com.smart.getasan.services.SafeApiCaller
import retrofit2.HttpException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GlobalRepository @Inject constructor(private val api: ApiInterface) : SafeApiCaller() {

    private val _responsesRegister = MutableLiveData<ResponseRegister>()
    private val _responseLogin = MutableLiveData<ResponseLogin>()


    fun registerUser(namaToko: String, email: String, password: String) = liveData {
        emit(ResultCustom.Loading)
        try {
            val response = api.registerUser(namaToko, email, password)
            _responsesRegister.value = response
        } catch (e: HttpException) {
            emit(ResultCustom.Error(e.message.toString()))
        }

        val data: LiveData<ResultCustom<ResponseRegister>> =
            _responsesRegister.map { ResultCustom.Success(it) }
        emitSource(data)
    }

    fun loginUser(email: String, password: String) = liveData {
        emit(ResultCustom.Loading)
        try {
            val response = api.loginUser( email, password)
            _responseLogin.value = response
        } catch (e: HttpException) {
            emit(ResultCustom.Error(e.message.toString()))
        }

        val data: LiveData<ResultCustom<ResponseLogin>> =
            _responseLogin.map { ResultCustom.Success(it) }
        emitSource(data)
    }


}