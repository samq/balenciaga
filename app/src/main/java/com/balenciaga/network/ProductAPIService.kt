package com.balenciaga.network

import retrofit2.http.GET

// Interface - Defines how Retrofit talks to the server using HTTP requests
interface ProductAPIService {
    // GET - Specify Endpoint. Appended to Base URL
    @GET("balenciaga.json")
    suspend fun getProducts(): List<NetworkProduct>
}