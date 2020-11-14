package com.balenciaga.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.balenciaga.network.ProductAPI
import com.balenciaga.network.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductViewModel() : ViewModel() {
    private var _response = MutableLiveData<List<Product>>()
    val response: LiveData<List<Product>>
        get() = _response

    init {
        getProducts()
    }

    private fun getProducts() {
        // Log.d("ProductViewModel - getProducts", "START")
        ProductAPI.retrofitService.getProducts().enqueue(
            object : Callback<List<Product>> {
                override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                    // Log.d("ProductViewModel - getProducts", "onFailure - ${t.message}")
                    _response.value = null
                }

                override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                    // Log.d("ProductViewModel - getProducts", "onSuccess - ${response.body()}")
                    _response.value = response.body()
                }
            })
    }
}