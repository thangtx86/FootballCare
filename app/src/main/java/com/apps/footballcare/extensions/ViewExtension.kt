package com.apps.footballcare.extensions

import android.view.View
import android.animation.Animator

import android.animation.AnimatorListenerAdapter
import android.app.Activity
import android.content.Context
import android.view.Display
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.apps.footballcare.R


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

fun View.goneWithAnimation() {
    this.animate()
        .translationY(0f)
        .alpha(0.0f)
        .setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                this@goneWithAnimation.gone()
            }
        })
}

fun View.visibilityWithAnimation(display: Display) {
    this.visibility()
    var slideRightOut = AnimationUtils.loadAnimation(this.context, R.anim.slide_right_out)
    this.layoutParams = ViewGroup.LayoutParams(display.width,0)
    this.startAnimation(slideRightOut)
}