package com.balenciaga.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.balenciaga.databases.Product

class ProductViewModel : ViewModel() {
    private var _products : MutableLiveData<List<Product>> = MutableLiveData()
}