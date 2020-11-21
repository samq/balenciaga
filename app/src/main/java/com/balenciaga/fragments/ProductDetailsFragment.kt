package com.balenciaga.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.balenciaga.databinding.FragmentProductDetailsBinding
import com.balenciaga.domains.Product
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@AndroidEntryPoint
class ProductDetailsFragment : Fragment() {

    private var _binding : FragmentProductDetailsBinding? = null
    private val binding
        get() = _binding!!

    private val args : ProductDetailsFragmentArgs by navArgs()
    private lateinit var product : Product

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentProductDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Deserialize to Product object
        product = Json.decodeFromString(args.product)
        // Binding Project object for usage (IE. BindingAdapters)
        binding.product = product
    }
}