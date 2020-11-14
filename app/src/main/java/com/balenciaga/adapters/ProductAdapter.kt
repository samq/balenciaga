package com.balenciaga.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.balenciaga.R
import com.balenciaga.databinding.ProductViewBinding
import com.balenciaga.models.ProductViewModel
import com.balenciaga.network.Product

class ProductAdapter(viewModel: ProductViewModel) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var products : List<Product>? = viewModel.response.value

    init {
        // Log.d("ProductAdapter", "init - $products")
    }

    class ProductViewHolder(binding: ProductViewBinding) : RecyclerView.ViewHolder(binding.root) {
        var productNameTextView : TextView = binding.productNameTextView
        var productPriceTextView : TextView = binding.productPriceTextView
        var productImageView : ImageView = binding.productImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        // View Binding
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ProductViewBinding.inflate(layoutInflater, parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        // Log.d("ProductAdapter", "onBindViewHolder - START - $products")
        holder.productNameTextView.text = products?.get(position)?.name
        holder.productPriceTextView.text = products?.get(position)?.price.toString()
        holder.productImageView.apply {
            setImageResource(R.drawable.android)
        }
    }

    override fun getItemCount(): Int = products?.size ?: 0

    fun updateProducts(updatedProductsList : List<Product>?) {
        products = updatedProductsList
        notifyDataSetChanged()
    }
}