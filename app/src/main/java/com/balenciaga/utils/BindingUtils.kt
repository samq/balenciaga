package com.balenciaga.utils

import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.balenciaga.R
import com.balenciaga.network.Product
import java.util.Locale

// Extension Functions

// PRODUCT LIST FRAGMENT
// BINDING UTILS

@BindingAdapter("productListImage")
fun ImageView.setProductListImage(product : Product?) {
    product?.let {
        val uri = "@drawable/_${it.id.replace('-', '_').toLowerCase(Locale.ROOT)}_a"
        val resourceID = resources.getIdentifier(uri, "drawable", context.packageName)
        setImageResource(resourceID)
        scaleType = ImageView.ScaleType.FIT_XY
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

@BindingAdapter("productListBorders")
fun FrameLayout.setProductListBorders(position: Int) {
    if(position % 2 == 0){ setBackgroundResource(R.drawable.border_bottom_and_right) }
    else { setBackgroundResource(R.drawable.border_bottom) }
}

// PRODUCT DETAILS FRAGMENT
// BINDING UTILS

@BindingAdapter("productPrice")
fun TextView.setProductPrice(product: Product?) {
    product?.let {
        text = resources.getString(R.string.productListPrice, it.price)
    }
}

@BindingAdapter("productImage")
fun ImageView.setProductImage(product: Product?) {
    product?.let {
        val uri = "@drawable/_${it.id.replace('-', '_').toLowerCase(Locale.ROOT)}_1"
        val resourceID = resources.getIdentifier(uri, "drawable", context.packageName)
        setImageResource(resourceID)
        scaleType = ImageView.ScaleType.FIT_START
    }
}

@BindingAdapter("productName")
fun TextView.setProductName(product: Product?) {
    product?.let {
        text = it.name
    }
}

@BindingAdapter("productDescription")
fun TextView.setProductDescription(product: Product?) {
    product?.let {
        text = it.description
    }
}

@BindingAdapter("productDimensionsAndComposition")
fun TextView.setProductDimensionsAndComposition(product: Product?) {
    var dimensionsAndCompositionText = "\n"
    product?.let {
        if(product.dimensions.isNotEmpty()) {
            dimensionsAndCompositionText += "${resources.getString(R.string.dimensions, it.dimensions)}\n"
        }
        dimensionsAndCompositionText += "${resources.getString(R.string.composition, it.composition)}\n"
    }
    text = dimensionsAndCompositionText
}

@BindingAdapter("productDetails")
fun TextView.setProductDetails(product: Product?) {
    product?.let {
        val detailsList = it.details.split(",").map { detail -> detail.trim() }
        var detailsText = ""
        // Add bullet point followed by the detail and then a newline
        detailsList.forEach { detail -> detailsText += "\u2022 $detail \n" }
        text = detailsText
    }
}

@BindingAdapter("productID")
fun TextView.setProductID(product: Product?) {
    product?.let {
        text = resources.getString(R.string.productID, it.id)
    }
}