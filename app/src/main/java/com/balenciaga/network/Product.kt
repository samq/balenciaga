package com.balenciaga.network

// Moshi - Parses JSON data and converts them into Kotlin objects
// Object that store parsed results
// Properties correspond to name in JSON object
// @Json(name="...") val ... - Annotation to map JSON attribute to different variable name
data class Product(
    val productID : String,
    val name : String,
    val price : Double,
    val description : String,
    val colors : String,
    val sizes : String,
    val dimensions : String,
    val composition : String,
    val details : String,
)

// Extension Function
// Converts Domain Object into Database Objects