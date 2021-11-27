package com.apps.footballcare.extensions

/**
 *
 * VariableExtension.kt.
 *
 * Created by thangtx on 11/06/21.
 *
 */
fun Int?.orZero(): Int = this ?: 0
fun Double?.orZero(): Double = this ?: 0.0
fun Float?.orZero(): Float = this ?: 0.0F
fun String?.orEmpty(): String = this ?: ""
fun Boolean?.orFalse(): Boolean = this ?: false
fun Boolean?.orTrue(): Boolean = this ?: true