package com.ddev.ecommerceapp.model

import com.google.gson.annotations.SerializedName

data class LoginData(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: Int
)
