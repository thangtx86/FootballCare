package com.apps.footballcare.view.league.choose_league.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apps.footballcare.R
import com.apps.footballcare.base.binding.setDisplay
import com.apps.footballcare.data.remote.model.League
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
    private val onLeagueItemClick: ((List<League>) -> Unit)?,
    private var listSelected: MutableList<League>
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(response: League) {
        binding.root.setOnClickListener {
            response.isSelected = !response.isSelected
            binding.imgSelect.setDisplay(response.isSelected)
            if (response.isSelected) {
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
            onPhotoItemClick: ((List<League>) -> Unit)?,
            listSelected: MutableList<League>
        ): LeagueViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_league, parent, false)
            val binding = ItemLeagueBinding.bind(view)
            return LeagueViewHolder(binding, onPhotoItemClick, listSelected)
        }
    }
}