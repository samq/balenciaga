package com.balenciaga.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.balenciaga.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    // Binding
    private var _binding : FragmentMainBinding? = null
    private val binding
        get() = _binding!!
    // Custom Handler Object that handles Navigation when Views are clicked in Fragment
    private val mainFragmentHandler : MainFragmentHandler = object : MainFragmentHandler {
        override fun navigateToCategoryFragment(view: View) {
            val directions = MainFragmentDirections.navigateToCategoryFragment((view as TextView).text.toString())
            findNavController().navigate(directions)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Bindings
        binding.mainFragmentHandler = mainFragmentHandler
    }
}

// Interface - Functions that will handle listeners calls in the MainFragment
interface MainFragmentHandler {
    // Navigates to the CategoryFragment
    fun navigateToCategoryFragment(view : View)
}