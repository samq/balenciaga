package com.balenciaga.domains

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id : String,
    val name : String,
    val price : Double,
    val description : String,
    val colors : List<String>,
    val sizes : List<String>,
    val dimensions : String,
    val composition : String,
    val details : List<String>,
)
