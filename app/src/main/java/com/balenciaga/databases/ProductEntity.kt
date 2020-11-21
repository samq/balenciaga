package com.balenciaga.databases

import androidx.room.Entity
import androidx.room.PrimaryKey

// Maps to SQLite table entry in the database
@Entity(tableName = "products")
data class ProductEntity(
    // Must have a PrimaryKey
    @PrimaryKey
    val id : String,
    // @ColumnInfo - Allows customization of column name in table
    val name : String,
    val price : Double,
    val description : String,
    val colors : String,
    val sizes : String,
    val dimensions : String,
    val composition : String,
    val details : String,
)