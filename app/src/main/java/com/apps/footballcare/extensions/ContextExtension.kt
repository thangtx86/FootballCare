package com.apps.footballcare.extensions

import android.content.Context
import androidx.fragment.app.Fragment

/**
 *
 * ContextExtension.kt.
 *
 * Created by thangtx on 11/06/21.
 *
 */
fun Fragment.runContextNotNull(block: (Context) -> Unit) {
    this.context?.let {
        block(it)
    }
}