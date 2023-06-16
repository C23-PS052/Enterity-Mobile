package com.bangkit.enterity.rest

import com.bangkit.enterity.model.ResponseLogin
import com.bangkit.enterity.model.ResponsePelanggan
import com.bangkit.enterity.model.ResponseProduct
import com.bangkit.enterity.model.ResponseProductChannel
import com.bangkit.enterity.model.ResponseRegister
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

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


    @GET("products/list")
    suspend fun getAllProductChannel(
        @Header("Authorization") token: String,
    ) : ResponseProductChannel

    @GET("products")
    suspend fun getAllProduct(
        @Header("Authorization") token: String,
    ) : ResponseProduct

    @GET("customers")
    suspend fun getAllPelanggan(
        @Header("Authorization") token: String,
    ) : ResponsePelanggan






}