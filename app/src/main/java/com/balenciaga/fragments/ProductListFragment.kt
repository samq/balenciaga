package com.balenciaga.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.balenciaga.adapters.ProductAdapter
import com.balenciaga.adapters.ProductListener
import com.balenciaga.databinding.FragmentProductListBinding
import com.balenciaga.models.ProductViewModel

class ProductListFragment : Fragment() {

    // View Binding
    private var _binding : FragmentProductListBinding? = null
    private val binding
        get() = _binding!!

    // ViewModel
    private val viewModel : ProductViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // View Binding
        _binding = FragmentProductListBinding.inflate(inflater, container, false)

        // RecyclerView
        val recyclerView = binding.productListRecyclerView
        // ViewManager
        val viewManager = GridLayoutManager(activity, 2)
        val viewAdapter = ProductAdapter(ProductListener {
            val direction = ProductListFragmentDirections.navigateToProductDetailsFragment(it)
            findNavController().navigate(direction)
        })

        // RecyclerView - Configuration
        recyclerView.apply {
            // Optimization - Improve performance if content change do not change layout size
            setHasFixedSize(true)
            // Uses specified LayoutManager and ViewAdapter
            layoutManager = viewManager
            adapter = viewAdapter
            // addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))
            // addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        }

        // ViewModel
        viewModel.response.observe(viewLifecycleOwner, Observer {
            it?.let {
                viewAdapter.submitList(it)
            }
        })

        return binding.root
    }
}