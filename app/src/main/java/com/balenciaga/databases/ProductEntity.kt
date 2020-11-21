package com.balenciaga.databases

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.balenciaga.network.NetworkProduct

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey
    val id : String,
    val name : String,
    val price : Double,
    val description : String,
    val colors : String,
    val sizes : String,
    val dimensions : String,
    val composition : String,
    val details : String,
    // val variations: List<String>,
)