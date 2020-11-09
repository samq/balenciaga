package com.balenciaga.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_table")
data class Product(
    @PrimaryKey @ColumnInfo(name="productID") val productID : String,
    @ColumnInfo(name="name") val name : String,
    @ColumnInfo(name="price") val price : Double,
    @ColumnInfo(name="images") val images : List<String>,
    @ColumnInfo(name="description") val description : String,
    @ColumnInfo(name="colors") val colors : List<String>,
    @ColumnInfo(name="sizes") val sizes : List<String>,
    @ColumnInfo(name="dimensions") val dimensions : String,
    @ColumnInfo(name="composition") val composition : String,
    @ColumnInfo(name="details") val details : List<String>,
    // @ColumnInfo(name="variations") val variations: List<String>,
)