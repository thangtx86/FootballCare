package com.apps.footballcare.view.video

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apps.footballcare.R
import kotlinx.android.synthetic.main.item_category.view.*


/**
 *
 * CategoryAdapter.kt.
 *
 * Created by thangtx on 11/07/21.
 *
 */
class CategoryAdapter :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private lateinit var categories: List<String>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
            .let(::CategoryViewHolder)
    }

    fun setCategories(categories: List<String>) {
        this.categories = categories
    }


    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        var item = categories[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = categories.size

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val categoryName = itemView.text_category_name!!
        fun bind(item: String) {
            categoryName.text = item.replaceFirstChar(Char::titlecase)


        }
    }
}