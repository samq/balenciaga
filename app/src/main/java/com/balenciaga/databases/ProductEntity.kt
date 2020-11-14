package com.balenciaga.databases

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.balenciaga.network.Product

@Entity(tableName = "products")
data class Product(
    @PrimaryKey
    val productID : String,
    val name : String,
    val price : Double,
    val images : String,
    val description : String,
    val colors : String,
    val sizes : String,
    val dimensions : String,
    val composition : String,
    val details : String,
    // val variations: List<String>,
)

// Extension Function
// Converts a List<Product> into List<ProductProperty>
// Converts Database Objects into Domain Objects
fun List<Product>.asDomainModel() : List<Product> {
    return map {
        Product(
            productID = it.productID,
            name = it.name,
            price = it.price,
            description = it.description,
            colors = it.colors,
            sizes = it.sizes,
            dimensions = it.dimensions,
            composition = it.composition,
            details = it.details
        )
    }
}