package com.balenciaga.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.balenciaga.R
import com.balenciaga.databinding.FragmentProductDetailsBinding
import com.balenciaga.network.Product
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

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

        product = Json.decodeFromString(args.product)

        binding.priceTextView.text = getString(R.string.productListPrice, product.price)
        binding.addToBagTextView.apply {
            text = getString(R.string.addToBag)
            setBackgroundColor(Color.parseColor("#44db5e"))
        }
    }
}