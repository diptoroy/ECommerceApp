package com.ddev.ecommerceapp.model

import com.google.gson.annotations.SerializedName

data class Expires(
    @SerializedName("date")
    val date: String,
    @SerializedName("timezone_type")
    val timezone_type: Int,
    @SerializedName("timezone")
    val timezone: String
)
