package com.bangkit.enterity.rest

import com.bangkit.enterity.model.ResponseLogin
import com.bangkit.enterity.model.ResponseRegister
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {

    @FormUrlEncoded
    @POST("register")
    suspend fun registerUser(
        @Field("nama_toko") namaToko: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): ResponseRegister

    @FormUrlEncoded
    @POST("login")
    suspend fun loginUser(
        @Field("email") email: String,
        @Field("password") password: String
    ): ResponseLogin

}