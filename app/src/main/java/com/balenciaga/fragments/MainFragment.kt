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

class MainFragment : Fragment() {

    private var _binding : FragmentMainBinding? = null
    // Property is only valid between onCreateView and onDestroyView
    private val binding
        get() = _binding!!
    //
    private val mainFragmentHandler : MainFragmentHandler = object : MainFragmentHandler {
        override fun navigateToCategoryFragment(view: View) {
            Log.d("MainFragment", "navigateToCategoryFragment Method")
            val directions = MainFragmentDirections.navigateToCategoryFragment()
            findNavController().navigate(directions)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_main, container, false)

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mainFragmentHandler = mainFragmentHandler
    }
}

// Interface - Functions that will handle listeners calls in the MainFragment
interface MainFragmentHandler {
    // Navigates to the CategoryFragment
    fun navigateToCategoryFragment(view : View)
}