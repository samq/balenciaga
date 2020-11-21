package com.balenciaga.models

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.balenciaga.domains.Product
import com.balenciaga.repository.ProductRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

// ViewModel
// @ViewModelInject - Makes use of Dagger/Hilt dependency injection (Repository)
class ProductViewModel @ViewModelInject constructor(
    private val repository: ProductRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    // MutableLiveData/LiveData that will be observable by Activities/Fragments
    private var _response = MutableLiveData<List<Product>>()
    // Property Backing - Encapsulation
    val response: LiveData<List<Product>>
        get() = _response

    init {
        // Coroutine with ViewModel scoping - Automatically canceled if ViewModel is cleared
        viewModelScope.launch {
            // Flow - collect - Terminal Operator - Suspend Function
            // Begins listening for values
            // Consumes the data from the Repository as it becomes available (emit)
            repository.getProducts().collect {
                _response.value = it
            }
        }
    }
}

// Manages the Events that may occur in VieWModel
sealed class MainStateEvent {
    object GetProductsEvents: MainStateEvent()
    object None: MainStateEvent()
}