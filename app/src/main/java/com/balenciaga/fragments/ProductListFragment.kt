package com.balenciaga.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.balenciaga.adapters.ProductAdapter
import com.balenciaga.databinding.FragmentProductListBinding
import com.balenciaga.models.ProductViewModel

class ProductListFragment : Fragment() {

    // View Binding
    private var _binding : FragmentProductListBinding? = null
    private val binding
        get() = _binding!!

    // ViewModel
    private val viewModel : ProductViewModel by viewModels()

    // RecyclerView
    private lateinit var recyclerView : RecyclerView
    private lateinit var viewAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>
    private lateinit var viewManager : RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // View Binding
        _binding = FragmentProductListBinding.inflate(inflater, container, false)

        // RecyclerView
        recyclerView = binding.productListRecyclerView
        // ViewManager
        viewManager = GridLayoutManager(activity, 2)
        viewAdapter = ProductAdapter(viewModel)

        // RecyclerView - Configuration
        recyclerView.apply {
            // Optimization - Improve performance if content change do not change layout size
            setHasFixedSize(true)
            // Uses specified LayoutManager and ViewAdapter
            layoutManager = viewManager
            adapter = viewAdapter
        }

        // ViewModel
        viewModel.response.observe(viewLifecycleOwner, Observer {
            (viewAdapter as ProductAdapter).updateProducts(it)
        })

        return binding.root
    }
}