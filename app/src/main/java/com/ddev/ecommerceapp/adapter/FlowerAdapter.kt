package com.ddev.ecommerceapp.adapter

import android.app.ProgressDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ddev.ecommerceapp.onclickListener.OnClickListener
import com.ddev.ecommerceapp.R
import com.ddev.ecommerceapp.model.FlowerData
import kotlinx.android.synthetic.main.item_row.view.*

class FlowerAdapter(private val onClickListener: OnClickListener) : RecyclerView.Adapter<FlowerAdapter.ViewHolder>() {
    private var flowerList = emptyList<FlowerData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.flowerName.text = flowerList[position].itemName.toString()
        holder.itemView.flowerStore.text = flowerList[position].itemStore.toString()
        holder.itemView.flowerPrice.text = flowerList[position].itemPrice.toString()
        Glide.with(holder.itemView.context).load(flowerList[position].itemImage[1].sliderImage).into(holder.itemView.flowerImage)

        holder.itemView.setOnClickListener{
            onClickListener.onClick(flowerList[position],position)
        }

        holder.itemView.cartBtn.setOnClickListener {
//            val builder: AlertDialog.Builder = AlertDialog.Builder(holder.itemView.context)
//            val view: View = LayoutInflater.from(holder.itemView.context).inflate(R.layout.add_dialog,null)
//
//            builder.setCancelable(true)
//            builder.setView(view)
//
//            val alertDialog: AlertDialog = builder.create()
//            alertDialog.show()

            val dialog = ProgressDialog(holder.itemView.context)
            dialog.show()
            dialog.setContentView(R.layout.add_dialog)
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        }

    }

    override fun getItemCount(): Int {
        return flowerList.size
    }

    fun setData(newList: List<FlowerData>){
        notifyDataSetChanged()
        flowerList = newList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}