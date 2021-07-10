package com.ddev.ecommerceapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ddev.ecommerceapp.R
import com.ddev.ecommerceapp.model.SliderData
import kotlinx.android.synthetic.main.slider_row.view.*

class SliderAdapter() : RecyclerView.Adapter<SliderAdapter.ViewHolder>() {
    private var imageData = emptyList<SliderData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.slider_row,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(imageData[position].sliderImage).into(holder.itemView.slider_img)

    }

    override fun getItemCount(): Int {
        return imageData.size
    }

    fun setData(newList: List<SliderData>){
        notifyDataSetChanged()
        imageData = newList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}