package com.ddev.ecommerceapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("success")
    @Expose
    val success: Success,
    @SerializedName("expires_at")
    @Expose
    val expires_at: Expires
)