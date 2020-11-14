package com.balenciaga.repository

import com.balenciaga.databases.ProductRoomDatabase
import com.balenciaga.network.ProductAPIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class ProductRepository(
    private val localDataSource : ProductRoomDatabase,
    private val remoteDataSource : ProductAPIService)
{
//    ProductAPI.retrofitService.getProducts().enqueue(
//        object : Callback<List<Product>> {
//            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
//                TODO()
//            }
//
//            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
//                TODO()
//            }
//        })

    // API used to refresh the offline cache
    suspend fun getProducts() {
        withContext(Dispatchers.IO) {}
    }
}