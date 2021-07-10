package com.ddev.ecommerceapp.view

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddev.ecommerceapp.R
import com.ddev.ecommerceapp.adapter.CartAdapter
import com.ddev.ecommerceapp.adapter.FlowerAdapter
import com.ddev.ecommerceapp.db.CartDatabase
import com.ddev.ecommerceapp.model.CartData
import com.ddev.ecommerceapp.model.FlowerData
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.fragment_flowers.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.ArrayList

class CartActivity : AppCompatActivity() {

    private val cartAdapter by lazy { CartAdapter() }
    private val cartList = ArrayList<CartData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        setSupportActionBar(toolbar3)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Your bag"

        LocalBroadcastManager.getInstance(this).registerReceiver(broadCastReceiver,IntentFilter("totalAmount"))

        addCartBtn.setOnClickListener {
            val intent = Intent(this,PaymentActivity::class.java)
            startActivity(intent)
        }

        GlobalScope.launch {
            setUpRecyclerView()
        }


    }

    private suspend fun setUpRecyclerView() {
        cart_recyclerview.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false

        )
        cart_recyclerview.setHasFixedSize(true)

//        cartList.add(CartData(R.drawable.pica,"PURE SUN FARMS","Indica blend","$20","01"))
//        cartList.add(CartData(R.drawable.pica,"PURE SUN FARMS","Indica blend","$20","01"))
//        cartList.add(CartData(R.drawable.pica,"PURE SUN FARMS","Indica blend","$20","02"))
//        cartList.add(CartData(R.drawable.pica,"PURE SUN FARMS","Indica blend","$20","01"))
//        cartList.add(CartData(R.drawable.pica,"PURE SUN FARMS","Indica blend","$20","01"))

        val cart: List<CartData> = CartDatabase.invoke(this).getCart().getAllCart()


        cart_recyclerview.adapter = cartAdapter
        cartAdapter.setData(cart)

    }

    private val broadCastReceiver = object : BroadcastReceiver() {
        override fun onReceive(contxt: Context?, intent: Intent?) {
            var totalAmount: Int = intent!!.getIntExtra("totalPrice",0)
            itemTotalPrice.text = "$$totalAmount"
        }
    }

}

