package com.balenciaga.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.balenciaga.R

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private val productNameList : List<String> = listOf<String>("PLACEHOLDER - NAME")
    private val productPriceList : List<String> = listOf<String>("PLACEHOLDER - PRICE")

    class ProductViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        var productViewHolder : FrameLayout = view.findViewById(R.id.productViewHolder)
        var productNameTextView : TextView = view.findViewById(R.id.productNameTextView)
        var productPriceTextView : TextView = view.findViewById(R.id.productPriceTextView)
        var productImageView : ImageView = view.findViewById(R.id.productImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_view, parent, false) as View
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.productNameTextView.text = productNameList[0]
        holder.productPriceTextView.text = productPriceList[0]
        holder.productImageView.apply {
            setImageResource(R.drawable.android)
            scaleType = ImageView.ScaleType.FIT_XY
        }
    }

    override fun getItemCount(): Int {
        return 20
    }
}