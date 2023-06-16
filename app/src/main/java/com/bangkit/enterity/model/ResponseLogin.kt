package com.bangkit.enterity.model

data class ResponseLogin(
    val accessToken: String,
    val message: String,
    val refresh_token: String,
    val status: String
)