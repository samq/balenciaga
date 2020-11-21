package com.balenciaga.databases

import androidx.room.*

// Data Acces Object
// Define the database interactions
// Methods abstract access to database
@Dao
interface ProductDao {
    // Delete a specific ProductEntity
    @Delete
    suspend fun deleteProduct(product : ProductEntity)
    // Inserts a ProductEntity. Replaces if there is a conflict
    // Returns a Long denoting the row in which entry is (-1 for Error)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product : ProductEntity) : Long
    // Returns all ProductEntity in database
    @Query("SELECT * FROM products")
    suspend fun getAllProducts() : List<ProductEntity>
    // Returns all ProductEntity with matching ID
    @Query("SELECT * FROM products WHERE id = :id")
    suspend fun getProductDetails(id : String) : List<ProductEntity>
    // Updates the ProductEntity entry
    @Update
    suspend fun updateProduct(product : ProductEntity)
}