package com.balenciaga.databases

import androidx.room.Database
import androidx.room.RoomDatabase

// RoomDatabase - Return the Data Access Object
@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
abstract class ProductRoomDatabase : RoomDatabase() {
    abstract fun getProductDAO(): ProductDao
}