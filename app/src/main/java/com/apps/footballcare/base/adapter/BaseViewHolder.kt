package com.apps.footballcare.base.adapter

import android.content.Context
import android.content.res.Resources
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

/**
 *
 * BaseViewHolder.kt
 *
 * Created by thangtx on 11/04/21 Android Studio
 *
 */
abstract class BaseViewHolder<in T>(itemView: View) : RecyclerView.ViewHolder(itemView),
    LayoutContainer {

    protected val context: Context = itemView.context
    protected val resources: Resources = itemView.resources
    abstract fun bind(data: T)
    override val containerView: View = itemView
}
