package com.ddev.ecommerceapp.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ddev.ecommerceapp.R
import com.ddev.ecommerceapp.model.CartData
import kotlinx.android.synthetic.main.cart_row.view.*

class CartAdapter : RecyclerView.Adapter<CartAdapter.ViewHolder>() {
    private var cartList = emptyList<CartData>()
    var totalPrice: Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_row,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.cartName.text = cartList[position].cartName.toString()
        holder.itemView.cartStore.text = cartList[position].cartStore.toString()
        holder.itemView.cartPrice.text = cartList[position].cartPrice.toString()
        holder.itemView.cart_quantity.text = cartList[position].cartQuantity.toString()
        Glide.with(holder.itemView.context).load(cartList[position].cartImage).into(holder.itemView.cartImage)
        Log.d("cartImage","${cartList[position].cartImage}")

        totalPrice = totalPrice.toInt() + cartList[position].cartPrice!!.toInt()
        val intent = Intent("totalAmount")
        intent.putExtra("totalPrice",totalPrice)

        LocalBroadcastManager.getInstance(holder.itemView.context).sendBroadcast(intent)



    }

    override fun getItemCount(): Int {
        return cartList.size
    }

    fun setData(newList: List<CartData>){
        notifyDataSetChanged()
        cartList = newList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}