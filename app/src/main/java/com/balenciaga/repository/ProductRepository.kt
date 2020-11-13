package com.balenciaga.repository

import com.balenciaga.databases.ProductRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRepository(private val roomDatabase : ProductRoomDatabase) {
    // API used to refresh the offline cache
    suspend fun refreshProducts() {
        withContext(Dispatchers.IO) {}
    }
}