package com.balenciaga.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.balenciaga.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding : FragmentMainBinding? = null
    // Property is only valid between onCreateView and onDestroyView
    private val binding
        get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_main, container, false)

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.womenTextView.setOnClickListener {
            navigateToCategoryFragment("women")
        }
        binding.allTextView.setOnClickListener {
            navigateToCategoryFragment("all")
        }
        binding.menTextView.setOnClickListener {
            navigateToCategoryFragment("men")
        }
    }

    private fun navigateToCategoryFragment(category: String) {
        val directions = MainFragmentDirections.navigateToCategoryFragment(category)
        findNavController().navigate(directions)
    }
}