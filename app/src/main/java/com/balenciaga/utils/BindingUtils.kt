package com.balenciaga.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.balenciaga.R
import com.balenciaga.network.Product
import java.util.*

// Extension Functions
@BindingAdapter("productListImage")
fun ImageView.setProductListImage(product : Product?) {
    product?.let {
        val uri = "@drawable/_${it.id.replace('-', '_').toLowerCase(Locale.ROOT)}_a"
        val resourceID = resources.getIdentifier(uri, "drawable", context.packageName)
        setImageResource(resourceID)
    }
}

@BindingAdapter("productListName")
fun TextView.setProductListName(product: Product?) {
    product?.let {
        text = it.name
    }
}

@BindingAdapter("productListPrice")
fun TextView.setProductListPrice(product: Product?) {
    product?.let {
        text = resources.getString(R.string.productListPrice, it.price)
    }
}