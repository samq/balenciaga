package com.balenciaga.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.balenciaga.databinding.ProductViewBinding
import com.balenciaga.models.ProductViewModel
import com.balenciaga.network.Product

class ProductAdapter(viewModel: ProductViewModel) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var products : List<Product>? = viewModel.response.value

    class ProductViewHolder(private val context: Context, private val binding: ProductViewBinding) : RecyclerView.ViewHolder(binding.root) {

        // bind - Sets the binding(s) needed by the ProductViewHolder
        fun bind(product : Product?) {
            if(product != null) {
                binding.product = product
                binding.productImageView.apply {
                    // Product ID
                    // Importing Assets:
                    // Adds underscore (_) to the start of filename (Cannot start with number)
                    // Replaces dashes (-) in filename with underscores (_)
                    // Causes all uppercase letters to become lowercase letters
                    val uri = "@drawable/_${product.productID.replace('-','_').toLowerCase()}_a"
                    val resourceID = resources.getIdentifier(uri, "drawable", context.packageName)
                    setImageResource(resourceID)
                }
            }
            binding.executePendingBindings()
        }

        // Static Method from - Generates ProductViewHolder via View Binding object
        companion object {
            fun from(parent: ViewGroup) : ProductViewHolder {
                // View Binding
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ProductViewBinding.inflate(layoutInflater, parent, false)
                return ProductViewHolder(parent.context, binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products?.get(position)
        holder.bind(product)
    }

    override fun getItemCount(): Int = products?.size ?: 0

    fun updateProducts(updatedProductsList : List<Product>?) {
        products = updatedProductsList
        notifyDataSetChanged()
    }
}