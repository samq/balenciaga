package com.balenciaga.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

// Base URL for API
private const val BASE_URL = "https://..."

// Moshi Object
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// Retrofit Object
// Converter - Tells Retrofit what to do with the data it gets back from the web service
// IE. ScalarsConvert - Primitive Type (String)
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

// Interface - Defines how Retrofit talkes to the webserver using HTTP requests
interface ProductAPIService {
    // GET - Specify Endpoint. Appended to Base URL
    // CALL Object - Used to start the request
    @GET("products")
    fun getProducts():
        Call<List<ProductProperty>>
}

// Object that initializes the Retrofit service
// create() - Creates the Retrofit service with specified interface
// Exposes service to the rest of the application via object
object ProductAPI {
    val retrofitService : ProductAPIService by lazy {
        retrofit.create(ProductAPIService::class.java)
    }
}

// Example ViewModel
// import retrofit2.Callback and ProductAPI
// ProductAPI.retrofitService.getProducts().enqueue( object : Callback<String> { ... })
// Implement fun onFailure(Call<String>, Throwable) and onResponse(Call<String>, Response<String>)
// Set response object in ViewModel to LiveData

// Moshi - Update
// object : Callback<List<ProductProperty>>
// call : Call<List<ProductProperty>>