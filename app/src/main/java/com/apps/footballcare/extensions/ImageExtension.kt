package com.apps.footballcare.extensions

import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.widget.ImageView
import androidx.palette.graphics.Palette
import com.apps.footballcare.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import timber.log.Timber

/**
 *
 * ImageExtension.kt.
 *
 * Created by thangtx on 11/05/21.
 *
 */

fun ImageView.loadImage(url: String) {
    val display = resources.displayMetrics
//    val size = Point()
//    display.getSize(size)
//    val width = (size.x) / 2
//    val height = ((size.y) / 2.2).roundToInt()
    if (url != null) {
        Picasso.get().load(url)
            .placeholder(R.drawable.ic_launcher_background)
//            .resize(width, height)
            .into(this)
    } else {
        Picasso.get().load(R.drawable.ic_launcher_background)
            .noFade()
            .resize(width, height)
            .into(this)
    }
}

fun ImageView.loadImageWithGradient(url: String, parentView: View) {
    Picasso.get().load(url).into(this, object : Callback {
        override fun onSuccess() {
            var bitmap = (this@loadImageWithGradient.drawable as BitmapDrawable).bitmap
            bitmap?.let {
                Palette.from(it).generate { palette ->
                    var dominantSwatch = palette?.dominantSwatch
                    var vibrantSwatch = palette?.vibrantSwatch
//                        binding.rootDetail.setBackgroundColor(vibrantSwatch?.rgb ?:
//                        ContextCompat.getColor(requireContext(), R.color.black))
                    var lightVibrantSwatch = palette?.lightVibrantSwatch?.rgb
                    var ibrant = palette?.vibrantSwatch?.rgb
                    var darkVibrantSwatch = palette?.darkVibrantSwatch?.rgb
                    var darkMuteSwatch = palette?.darkMutedSwatch?.rgb
                    var muteSwatch = palette?.mutedSwatch?.rgb
                    var lightMutedSwatch = palette?.lightMutedSwatch?.rgb
//                    Timber.e(PhotoDetailFragment.TAG + " :  DomiantSwatch:----: " + dominantSwatch?.bodyTextColor)
//                    Timber.e(PhotoDetailFragment.TAG + " :  VibrantSwatch:----: " + vibrantSwatch?.bodyTextColor)
//                    Timber.e(PhotoDetailFragment.TAG + " :  lightVibrantSwatch:----: " + palette?.lightVibrantSwatch?.bodyTextColor)
//                    Timber.e(PhotoDetailFragment.TAG + " :  darkVibrantSwatch:----: " + palette?.darkVibrantSwatch?.bodyTextColor)
//                    Timber.e(PhotoDetailFragment.TAG + " :  darkMutedSwatch:----: " + palette?.darkMutedSwatch?.bodyTextColor)
//                    Timber.e(PhotoDetailFragment.TAG + " :  mutedSwatch:----: " + palette?.mutedSwatch?.bodyTextColor)
//                    Timber.e(PhotoDetailFragment.TAG + " :  lightMutedSwatch:----: " + palette?.lightMutedSwatch?.bodyTextColor)

                    val orientation = if (muteSwatch == null) {
                        GradientDrawable.Orientation.BL_TR
                    } else {
                        GradientDrawable.Orientation.TR_BL
                    }

                    val gradientColor = GradientDrawable(
                        orientation,
                        intArrayOf(
                            dominantSwatch?.rgb ?: android.R.color.transparent,
                            muteSwatch ?: android.R.color.transparent,
                            vibrantSwatch?.rgb ?: muteSwatch ?: android.R.color.transparent
                        )
                    )
                    gradientColor.gradientType = GradientDrawable.LINEAR_GRADIENT
                    parentView.background = gradientColor


                }
            }
        }

        override fun onError(e: Exception?) {
            Timber.e(e)
            e?.printStackTrace()
        }

    })
}



