package com.bangkit.enterity.model

data class ResponseLogin(
    val access_token: String,
    val message: String,
    val refresh_token: String,
    val status: String
)