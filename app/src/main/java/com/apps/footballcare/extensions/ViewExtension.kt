package com.apps.footballcare.extensions

import android.view.View

/**
 *
 * ViewExtension.kt.
 *
 * Created by thangtx on 11/27/21.
 *
 */

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisibility() {
    this.visibility = View.INVISIBLE
}

fun View.visibility() {
    this.visibility = View.VISIBLE
}