package com.balenciaga.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.balenciaga.utils.Converters

@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ProductRoomDatabase : RoomDatabase() {
    abstract fun getProductDAO(): ProductDao
}