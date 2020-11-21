package com.balenciaga.repository

import android.util.Log
import com.balenciaga.databases.ProductDao
import com.balenciaga.domains.Product
import com.balenciaga.mappers.CacheMapper
import com.balenciaga.mappers.NetworkMapper
import com.balenciaga.network.ProductAPIService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProductRepository(
    private val localDataSource: ProductDao,
    private val remoteDataSource: ProductAPIService,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) {

    suspend fun getProducts() : Flow<List<Product>> = flow {
        Log.d("ProductRepository", "getProducts() - Start")
        val networkProducts = remoteDataSource.getProducts()
        val products = networkMapper.mapFromEntityList(networkProducts)
        for(product in products) {
            localDataSource.insertProduct(cacheMapper.mapToEntity(product))
            Log.d("ProductRepository", "$product.name")
        }
        val cachedProducts = localDataSource.getAllProducts()
        emit(cacheMapper.mapFromEntityList(cachedProducts))
    }
}