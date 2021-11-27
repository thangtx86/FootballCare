package com.apps.footballcare.extensions

/**
 *
 * StringExtension.kt.
 *
 * Created by thangtx on 11/06/21.
 *
 */
fun CharSequence.chunkedRightSequence(): Sequence<String> {
    if (isEmpty()) return emptySequence()
    val firstSize = (length - 1) % 3 + 1
    return sequenceOf(substring(0, firstSize)) +
            (firstSize until length step 3).asSequence()
                .map { substring(it, it + 3) }
}

fun Int.intToString():String = this.toString()
