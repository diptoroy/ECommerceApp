package com.ddev.ecommerceapp.view

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.ddev.ecommerceapp.R
import com.ddev.ecommerceapp.adapter.SliderAdapter
import com.ddev.ecommerceapp.db.CartDatabase
import com.ddev.ecommerceapp.model.CartData
import com.ddev.ecommerceapp.model.SliderData
import kotlinx.android.synthetic.main.activity_flower_details.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import me.relex.circleindicator.CircleIndicator3


class FlowerDetailsActivity : AppCompatActivity() {

    var quantity: Int = 1
    var totalPrice: Int = 0
    var id: Int = 0

    private val imageAdapter by lazy { SliderAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flower_details)

        setSupportActionBar(toolbar2)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //intent data
        val bundle:Bundle? = intent.extras
        id = bundle!!.getInt("id")
        val name: String? = bundle!!.getString("name")
        itemName.text = name
        var store: String? = bundle!!.getString("store")
        itemStore.text = store
        var price: Int? = bundle!!.getInt("price")

        //slider
        val intentData = intent.getParcelableArrayListExtra<SliderData>("list") as ArrayList<SliderData>
        val img: Int = intentData[1].sliderImage
        Log.d("first image", "$img")
        val bitmap = BitmapFactory.decodeResource(resources, img, null)
        Log.d("intent", "$intentData")

        viewPager.adapter = imageAdapter
        imageAdapter.setData(intentData)
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val indicator = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(viewPager)

        //quantity button
        details_plus.setOnClickListener {
            if (quantity < 10) {
                quantity++
                itemQuatity.text = quantity.toString()
                if (price != null) {
                    totalPrice = price * quantity
                    itemTotalPrice.text = "$$totalPrice"
                }
            }
        }

        details_minus.setOnClickListener {
            if (quantity > 1) {
                quantity--
                itemQuatity.text = quantity.toString()
                if (price != null) {
                    totalPrice = price * quantity
                    itemTotalPrice.text = "$$totalPrice"
                }
            }
        }

        itemTotalPrice.text = "$$price"



        GlobalScope.launch {
            if (CartDatabase.invoke(this@FlowerDetailsActivity).getCart()
                    .isCart(id) != 1
            ) {
                addbagBtn.text = "Add to bag"
            } else {
                addbagBtn.text = "Remove from bag"
            }

        }

        addbagBtn.setOnClickListener {
            //cart add
            val cart = CartData()

            cart.cartId = id
            cart.cartName = name
            cart.cartStore = store
            cart.cartPrice = totalPrice.toString()
            cart.cartQuantity = quantity.toString()
            cart.cartImage = bitmap

            GlobalScope.launch {
                if (CartDatabase.invoke(this@FlowerDetailsActivity).getCart()
                        .isCart(id) != 1
                ) {
                    CartDatabase.invoke(this@FlowerDetailsActivity).getCart()
                        .cartInsert(cart)
                } else {
//                    CartDatabase.invoke(this@FlowerDetailsActivity).getCart()
//                        .cartDelete(cart)
                }

            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.details_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id = item.itemId
        when(id){
            R.id.share -> {
                val intent = Intent(this, SearchActivity::class.java)
                startActivity(intent)
            }
            R.id.dCart -> {
                val intent = Intent(this, CartActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}