package com.balenciaga.databases

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProductDao {
    @Delete
    fun deleteProduct(product : Product)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product : Product)

    @Query("SELECT * FROM products")
    fun loadAllProducts() : LiveData<List<Product>>

    @Query("SELECT * FROM products WHERE productID = :productID")
    fun loadProductDetails(productID : String) : LiveData<Product>

    @Update
    fun updateProduct(product : Product)
}