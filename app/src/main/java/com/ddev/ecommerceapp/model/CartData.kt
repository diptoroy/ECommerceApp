package com.ddev.ecommerceapp.model

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_table")
data class CartData(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name= "id")
    var cartId: Int? = 0,
    @ColumnInfo(name= "image")
    var cartImage: Bitmap? = null,
    @ColumnInfo(name= "store")
    var cartStore: String? = null,
    @ColumnInfo(name= "name")
    var cartName: String? = null,
    @ColumnInfo(name= "price")
    var cartPrice: String? = null,
    @ColumnInfo(name= "quantity")
    var cartQuantity: String? = null
)
