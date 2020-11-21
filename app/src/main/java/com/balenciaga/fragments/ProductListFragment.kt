package com.balenciaga.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.balenciaga.R
import com.balenciaga.adapters.ProductAdapter
import com.balenciaga.adapters.ProductListener
import com.balenciaga.databinding.FragmentProductListBinding
import com.balenciaga.models.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment() {

    // View Binding
    private var _binding : FragmentProductListBinding? = null
    private val binding
        get() = _binding!!
    // ViewModel
    private val viewModel : ProductViewModel by viewModels()
    // Navigation Arguments
    private val args : ProductListFragmentArgs by navArgs()
    private lateinit var category : String

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
            viewAdapter.submitList(it)
            Log.d("ProductListFragment", "observe - response")
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Argument passed by MainFragment
        category = args.category
        // Send data to child (SearchbarFragment)
        childFragmentManager.findFragmentById(R.id.searchbarFragment)?.arguments = bundleOf(Pair("category", category))
    }
}