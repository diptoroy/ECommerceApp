package com.ddev.ecommerceapp.remote

import com.ddev.ecommerceapp.model.LoginResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {
    @POST("login")
     fun getLogin(
        @Field("email") email: String,
        @Field("password") password: Int
    ): Call<LoginResponse>
}