package com.ddev.ecommerceapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ddev.ecommerceapp.model.CartData

@Database(
    entities = [CartData::class],
    version = 1
)
@TypeConverters(Converter::class)
abstract class CartDatabase: RoomDatabase(){
    abstract fun getCart(): CartDao

    companion object{
        @Volatile
        private var instance : CartDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK){
                instance
                    ?: buildDatabase(context).also{
                        instance = it
                    }
            }
        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            CartDatabase::class.java,
            "cartDatabase"
        ).build()
    }
}