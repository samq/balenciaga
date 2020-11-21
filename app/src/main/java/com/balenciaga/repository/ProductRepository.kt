package com.balenciaga.repository

import com.balenciaga.databases.ProductDao
import com.balenciaga.domains.Product
import com.balenciaga.mappers.CacheMapper
import com.balenciaga.mappers.NetworkMapper
import com.balenciaga.network.ProductAPIService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

// Repository
// localDataSource - RoomDatabase / DAO / Entity / SQLite Architecture
// remoteDataSource - Retrofit
// Mappers
// Converts Network Objects into Domain Objects and vice versa
// Converts Cache Objects (Entity) into Domain Objects vice versa
class ProductRepository(
    private val localDataSource: ProductDao,
    private val remoteDataSource: ProductAPIService,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) {

    // Returns List<Product> as a Flow
    suspend fun getProducts() : Flow<List<Product>> = flow {
        // Calls the remoteDataSource (HTTP Request) and returns List<NetworkProduct>
        val networkProducts = remoteDataSource.getProducts()
        // Converts List<NetworkProducts> into List<Product> (Domain Objects) to be used by app
        val products = networkMapper.mapFromEntityList(networkProducts)
        // Iterates through List<Product>
        for(product in products) {
            // Converts Product to Entity object (ProductEntity) for local database storage
            localDataSource.insertProduct(cacheMapper.mapToEntity(product))
        }
        // Grabs the local data from the database
        val cachedProducts = localDataSource.getAllProducts()
        // Emit values as they are made available
        emit(cacheMapper.mapFromEntityList(cachedProducts))
    }
}