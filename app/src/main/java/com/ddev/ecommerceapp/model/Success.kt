package com.ddev.ecommerceapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Success(
    @SerializedName("token")
    @Expose
    val token: String
)
