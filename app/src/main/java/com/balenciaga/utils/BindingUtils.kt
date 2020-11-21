package com.balenciaga.utils

import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.balenciaga.R
import com.balenciaga.domains.Product
import java.util.Locale

// Utility Functions
// Extension Functions
// Used for making the right framework calls to set values for Views/ViewGroups in layout

// SEARCHBAR FRAGMENT
//
//
@BindingAdapter("productCategory")
fun TextView.setCategory(category : String) {
    text = category
}

// PRODUCT LIST FRAGMENT
//
// Sets the product's display image in ViewHolder
// Images for listings follow a particular format
// Underscore (_), followed by the Product ID, another underscore (_), and the letter a (lowercase)
// When importing images via Android Studio, the leading underscore was automatically added
// and all dashes (-) were replaced with underscores (_)
@BindingAdapter("productListImage")
fun ImageView.setProductListImage(product : Product?) {
    product?.let {
        val uri = "@drawable/_${it.id.replace('-', '_').toLowerCase(Locale.ROOT)}_a"
        val resourceID = resources.getIdentifier(uri, "drawable", context.packageName)
        setImageResource(resourceID)
        scaleType = ImageView.ScaleType.FIT_XY
    }
}
// Sets the product's name in ViewHolder
@BindingAdapter("productListName")
fun TextView.setProductListName(product: Product?) {
    product?.let {
        text = it.name
    }
}
// Sets the product's price in ViewHolder
@BindingAdapter("productListPrice")
fun TextView.setProductListPrice(product: Product?) {
    product?.let {
        text = resources.getString(R.string.productListPrice, it.price)
    }
}
// Items in RecyclerView are displayed in a two column grid layout.
// Items on the left will have it's bottom and right borders displayed.
// Items on the right will have it's bottom displayed only.
// This is to prevent additional right/left border to display on the side of the screen.
// Decorators could be used instead on RecyclerView
@BindingAdapter("productListBorders")
fun FrameLayout.setProductListBorders(position: Int) {
    if(position % 2 == 0){ setBackgroundResource(R.drawable.border_bottom_and_right) }
    else { setBackgroundResource(R.drawable.border_bottom) }
}

// PRODUCT DETAILS FRAGMENT
//
// Sets the product's price on the ProductDetailsFragment
@BindingAdapter("productPrice")
fun TextView.setProductPrice(product: Product?) {
    product?.let {
        text = resources.getString(R.string.productListPrice, it.price)
    }
}
// Sets the product's image on the ProductDetailsFragment
// Image name follows the format: Underscore (_), Product ID, Underscore (_), and number 1
@BindingAdapter("productImage")
fun ImageView.setProductImage(product: Product?) {
    product?.let {
        val uri = "@drawable/_${it.id.replace('-', '_').toLowerCase(Locale.ROOT)}_1"
        val resourceID = resources.getIdentifier(uri, "drawable", context.packageName)
        setImageResource(resourceID)
        scaleType = ImageView.ScaleType.FIT_START
    }
}
// Sets the product's name on the ProductDetailsFragment
@BindingAdapter("productName")
fun TextView.setProductName(product: Product?) {
    product?.let {
        text = it.name
    }
}
// Sets the product's description on the ProductDetailsFragment
@BindingAdapter("productDescription")
fun TextView.setProductDescription(product: Product?) {
    product?.let {
        text = it.description
    }
}
// Sets the product's dimensions and composition on the ProductDetailsFragment
// Dimensions are not always available for product to be displayed and needs to be checked
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
// Sets the product's detailed description in the ProductDetailsFragment
// Detailed Description is stored in a list so is iterated through
@BindingAdapter("productDetails")
fun TextView.setProductDetails(product: Product?) {
    product?.let {
        val detailsList = it.details.map { detail -> detail.trim() }
        var detailsText = ""
        // Add bullet point followed by the detail and then a newline
        detailsList.forEach { detail -> detailsText += "\u2022 $detail \n" }
        text = detailsText
    }
}
// Sets the product's ID in the ProductDetailsFragment
@BindingAdapter("productID")
fun TextView.setProductID(product: Product?) {
    product?.let {
        text = resources.getString(R.string.productID, it.id)
    }
}