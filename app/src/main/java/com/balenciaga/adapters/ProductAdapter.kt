package com.balenciaga.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.balenciaga.databinding.ProductViewBinding
import com.balenciaga.domains.Product
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

// Adapter
// RecyclerView.Adapter<ProductAdapter.ProductViewHolder>()

// ListAdapter
// Arguments - Type of Data List Holds, ViewHolder
// Constructor Parameter - DiffCallback - Used to figure out what change when list updates
// ListAdapter<Product, ProductAdapter.ProductViewHolder>(ProductDiffCallback())

class ProductAdapter(private val clickListener: ProductListener)
    : ListAdapter<Product, ProductAdapter.ProductViewHolder>(ProductDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = getItem(position)
        holder.bind(product, position, clickListener)
    }
    // ViewHolder
    class ProductViewHolder private constructor(private val binding: ProductViewBinding) : RecyclerView.ViewHolder(binding.root) {
        // bind - Sets the binding(s) needed by the ProductViewHolder
        fun bind(product: Product, position: Int, clickListener: ProductListener) {
            binding.product = product
            binding.clickListener = clickListener
            binding.position = position
            binding.executePendingBindings()
        }
        // Static Method from - Generates ProductViewHolder via View Binding object
        companion object {
            fun from(parent: ViewGroup) : ProductViewHolder {
                // View Binding
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ProductViewBinding.inflate(layoutInflater, parent, false)
                return ProductViewHolder(binding)
            }
        }
    }
}

// Determines if Product is added, removed, moved, or changed
class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
    // Checks if Products are the same
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }
    // Checks if Product contents have changed (equality check via data class)
    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}
// Listener Class
// onClick triggered when using taps Product in RecyclerView
// Constructor - Function
// onclick - Calls function passed via constructor
class ProductListener(val clickListener : (product: String) -> Unit) {
    fun onClick(product: Product) = clickListener(Json.encodeToString(product))
}