package com.balenciaga.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.core.os.bundleOf
import androidx.core.view.size
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.balenciaga.R
import com.balenciaga.activities.MainActivity
import com.balenciaga.databinding.FragmentCategoryBinding
import org.w3c.dom.Text

class CategoryFragment : Fragment() {

    private var _binding : FragmentCategoryBinding? = null
    private val binding
        get() = _binding!!

    private val args : CategoryFragmentArgs by navArgs()
    private lateinit var category : String

    // Handler Object
    private val categoryFragmentHandler : CategoryFragmentHandler = object : CategoryFragmentHandler {
        // Handles navigation based on which TextView is clicked
        override fun navigateToProductList(view: View) {
            val textView : TextView = view as TextView
            // Back TextView clicked
            if(textView.text.toString() == resources.getString(R.string.back)) {
                onBackPressed()
            }
            // Navigate to ProductListFragment
            // Passes category string to be used as a filter for results
            else {
                val directions = CategoryFragmentDirections.navigateToProductListFragment(view.text.toString())
                findNavController().navigate(directions)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Back Press Handler
        requireActivity().onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() = onBackPressed()
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Argument passed by MainFragment
        category = args.category
        // Send data to child (SearchbarFragment)
        childFragmentManager.findFragmentById(R.id.searchbarFragment)?.arguments = bundleOf(Pair("category", category))

        binding.categoryFragmentHandler = categoryFragmentHandler

        (activity as MainActivity).unhideToolbarIcons()
    }

    // Hides the Toolbar Icons and returns to the previous screen
    private fun onBackPressed() {
        (activity as MainActivity).hideToolbarIcons()
        findNavController().popBackStack()
    }
}

interface CategoryFragmentHandler {
    fun navigateToProductList(view: View)
}