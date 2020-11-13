package com.balenciaga.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.balenciaga.R
import com.balenciaga.databinding.ProductViewBinding
import com.balenciaga.databases.Product
import com.balenciaga.models.ProductViewModel

class ProductAdapter(viewModel: ProductViewModel) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var products : List<Product> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
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
        holder.productNameTextView.text = products[position].name
        holder.productPriceTextView.text = products[position].price.toString()
        holder.productImageView.apply {
            setImageResource(R.drawable.android)
        }
    }

    override fun getItemCount(): Int = products.size
}