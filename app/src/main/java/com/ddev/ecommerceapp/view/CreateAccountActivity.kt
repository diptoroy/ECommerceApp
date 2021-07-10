package com.ddev.ecommerceapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ddev.ecommerceapp.R
import com.ddev.ecommerceapp.model.LoginResponse
import com.ddev.ecommerceapp.remote.ApiClient
import kotlinx.android.synthetic.main.activity_create_account.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class CreateAccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        c_login_btn.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }

        create_btn.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

//            val email: String = email_input.text.toString().trim()
//            val password: String = password_input.text.toString().trim()
//            if (email.isEmpty()){
//                email_input.error = "Please enter your email"
//                email_input.requestFocus()
//                return@setOnClickListener
//            }else if(password.isEmpty()){
//                password_input.error = "Please enter your password"
//                password_input.requestFocus()
//                return@setOnClickListener
//            }else{
//                signInUser(email,password)
//            }
//        }
    }
        }

//    private fun signInUser(email: String, password: String) {
//        var call: Call<LoginResponse> = ApiClient.api.getLogin(email,password.toInt())
//
//        call.enqueue(object : Callback<LoginResponse>{
//            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
//                var res: LoginResponse? = response.body()
//                if (response.isSuccessful){
//                    val intent = Intent(this@CreateAccountActivity,HomeActivity::class.java)
//                    startActivity(intent)
//                }else{
//
//                }
//            }
//
//            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//        })
//    }

}
