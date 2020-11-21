package com.balenciaga.databases

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProductDao {
    @Delete
    suspend fun deleteProduct(product : ProductEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product : ProductEntity) : Long

    @Query("SELECT * FROM products")
    suspend fun getAllProducts() : List<ProductEntity>

    @Query("SELECT * FROM products WHERE id = :id")
    suspend fun getProductDetails(id : String) : List<ProductEntity>

    @Update
    suspend fun updateProduct(product : ProductEntity)
}