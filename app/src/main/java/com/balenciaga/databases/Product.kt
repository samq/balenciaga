package com.balenciaga.databases

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey
    val productID : String,
    val name : String,
    val price : Double,
    val images : List<String>,
    val description : String,
    val colors : List<String>,
    val sizes : List<String>,
    val dimensions : String,
    val composition : String,
    val details : List<String>,
    // val variations: List<String>,
)