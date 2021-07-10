package com.ddev.ecommerceapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FlowerData(
    val id: Int,
    val itemImage: List<SliderData>,
    val itemStore: String,
    val itemName: String,
    val itemPrice: Int
):Parcelable
