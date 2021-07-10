package com.ddev.ecommerceapp.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ddev.ecommerceapp.model.CartData

@Dao
interface CartDao {
    @Insert
    suspend fun cartInsert(cart: CartData)

    @Query("SELECT * FROM cart_table")
    suspend fun getAllCart(): List<CartData>

    @Query("SELECT EXISTS (SELECT 1 FROM cart_table WHERE id= :id)")
    suspend fun isCart(id: Int): Int

    @Delete
    suspend fun cartDelete(cart: CartData)
}