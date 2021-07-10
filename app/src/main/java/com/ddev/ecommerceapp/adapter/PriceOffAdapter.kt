package com.ddev.ecommerceapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ddev.ecommerceapp.R
import com.ddev.ecommerceapp.model.PriceOffData
import kotlinx.android.synthetic.main.price_off_row.view.*
import java.util.Collections.emptyList

class PriceOffAdapter : RecyclerView.Adapter<PriceOffAdapter.ViewHolder>() {
    private var priceOffList = emptyList<PriceOffData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.price_off_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.itemView.movieName.text = [position].title.toString()
         Glide.with(holder.itemView.context).load(priceOffList[position].priceOffImg)
            .into(holder.itemView.price_off_img)


    }

    override fun getItemCount(): Int {
        return priceOffList.size
    }

    fun setData(newList: List<PriceOffData>) {
        notifyDataSetChanged()
        priceOffList = newList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}