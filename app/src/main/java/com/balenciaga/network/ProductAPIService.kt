package com.balenciaga.network

import retrofit2.http.GET

// Interface - Defines how Retrofit talkes to the webserver using HTTP requests
interface ProductAPIService {
    // GET - Specify Endpoint. Appended to Base URL
    // CALL Object - Used to start the request
    @GET("balenciaga.json")
    suspend fun getProducts(): List<NetworkProduct>
}