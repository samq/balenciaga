package com.balenciaga.utils

import android.widget.FrameLayout
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