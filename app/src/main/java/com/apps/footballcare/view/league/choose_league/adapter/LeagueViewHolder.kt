package com.apps.footballcare.view.league.choose_league.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.apps.footballcare.R
import com.apps.footballcare.base.binding.setDisplay
import com.apps.footballcare.data.remote.model.Response
import com.apps.footballcare.databinding.ItemLeagueBinding
import timber.log.Timber

/**
 *
 * LeagueViewHolder.kt.
 *
 * Created by thangtx on 11/27/21.
 *
 */
class LeagueViewHolder(
    private val binding: ItemLeagueBinding,
    private val onLeagueItemClick: ((List<Response>) -> Unit)?,
    private var listSelected: MutableList<Response>
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(response: Response) {
        binding.root.setOnClickListener {
            response.isSelect = !response.isSelect
            binding.imgSelect.setDisplay(response.isSelect)
            if (response.isSelect) {
                listSelected.add(response)
            } else {
                listSelected.remove(response)
            }

            onLeagueItemClick?.invoke(listSelected)
            Timber.e("" + listSelected.size)
        }
        binding.response = response
        binding.executePendingBindings()
    }

    companion object {
        fun create(
            parent: ViewGroup,
            onPhotoItemClick: ((List<Response>) -> Unit)?,
            listSelected: MutableList<Response>
        ): LeagueViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_league, parent, false)
            val binding = ItemLeagueBinding.bind(view)
            return LeagueViewHolder(binding, onPhotoItemClick, listSelected)
        }
    }
}