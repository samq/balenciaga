package com.balenciaga.domains

data class Product(
    val productID : String,
    val name : String,
    val price : Double,
    val images : List<String>,
    val description : List<String>,
    val colors : List<String>,
    val sizes : List<String>,
    val dimensions : String,
    val composition : String,
    val details : List<String>,
)
