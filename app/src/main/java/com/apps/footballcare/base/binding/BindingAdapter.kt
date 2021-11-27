package com.apps.footballcare.base.binding

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.apps.footballcare.extensions.chunkedRightSequence
import com.apps.footballcare.extensions.gone
import com.apps.footballcare.extensions.invisibility
import com.apps.footballcare.extensions.visibility
import com.squareup.picasso.Picasso
import timber.log.Timber

/**
 *
 * BindingAdapter.kt
 *
 * Created by thangtx on 11/04/21 Android Studio
 *
 */
@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {
    url?.let { imageUrl ->
        Picasso.get().load(imageUrl).into(imageView)
    }
}

@BindingAdapter("formatComma")
fun TextView.insertComma(text: String) {
    text?.let { it ->
        this.text = it.chunkedRightSequence().joinToString(",")
    }

}

@BindingAdapter("display")
fun View.setDisplay(isDisplay: Boolean) {
    if (!isDisplay) {
        this.invisibility()
    } else {
        this.visibility()
    }
}
