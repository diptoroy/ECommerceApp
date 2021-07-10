package com.ddev.ecommerceapp.onclickListener

import com.ddev.ecommerceapp.model.FlowerData

interface OnClickListener{
    fun onClick(item: FlowerData, position: Int)
}