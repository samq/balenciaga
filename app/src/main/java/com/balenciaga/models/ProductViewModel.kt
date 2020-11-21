package com.balenciaga.models

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.balenciaga.domains.Product
import com.balenciaga.repository.ProductRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ProductViewModel @ViewModelInject constructor(
    private val repository: ProductRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _response = MutableLiveData<List<Product>>()
    val response: LiveData<List<Product>>
        get() = _response

    init {
        viewModelScope.launch {
            repository.getProducts().collect {
                _response.value = it
            }
        }
    }
}

sealed class MainStateEvent {
    object GetProductsEvents: MainStateEvent()
    object None: MainStateEvent()
}