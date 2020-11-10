package com.balenciaga.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.balenciaga.entities.Product
import com.balenciaga.utils.Converters

@Database(entities = [Product::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ProductRoomDatabase : RoomDatabase() {
    abstract val productDao : ProductDao

    companion object {
        @Volatile
        private var INSTANCE : ProductRoomDatabase? = null

        fun getInstance(context: Context) : ProductRoomDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ProductRoomDatabase::class.java,
                        "product_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return instance
            }
        }
    }
}