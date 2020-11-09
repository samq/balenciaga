package com.balenciaga.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.balenciaga.adapters.ProductAdapter
import com.balenciaga.databinding.FragmentProductListBinding

class ProductListFragment : Fragment() {

    // View Binding
    private var _binding : FragmentProductListBinding? = null
    private val binding
        get() = _binding!!

    private lateinit var recyclerView : RecyclerView
    private lateinit var viewAdapter : RecyclerView.Adapter<*>
    private lateinit var viewManager : RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // View Binding
        _binding = FragmentProductListBinding.inflate(inflater, container, false)

        // RecyclerView
        recyclerView = binding.productListRecyclerView
        // ViewManager
        viewManager = GridLayoutManager(activity, 2)
        viewAdapter = ProductAdapter()

        recyclerView.apply {
            // Optimization - Improve performance if content change do not change layout size
            setHasFixedSize(true)
            // Uses specified LayoutManager and ViewAdapter
            layoutManager = viewManager
            adapter = viewAdapter
        }

        return binding.root
    }
}