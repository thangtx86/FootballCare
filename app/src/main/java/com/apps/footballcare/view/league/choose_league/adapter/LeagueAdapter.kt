package com.apps.footballcare.view.league.choose_league.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.apps.footballcare.data.remote.model.League

/**
 *
 * LeagueAdapter.kt.
 *
 * Created by thangtx on 11/27/21.
 *
 */
class LeagueAdapter : ListAdapter<League, LeagueViewHolder>(LEAGUE_COMPARATOR) {
    /** Item Click Functions **/
     var onLeagueItemClick: ((List<League>) -> Unit)? = null
    var listSelected = mutableListOf<League>()

    companion object {
        private val LEAGUE_COMPARATOR = object : DiffUtil.ItemCallback<League>() {
            override fun areItemsTheSame(oldItem: League, newItem: League): Boolean =
                oldItem.leagueId == newItem.leagueId

            override fun areContentsTheSame(oldItem: League, newItem: League): Boolean =
                oldItem.leagueId == newItem.leagueId
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        return LeagueViewHolder.create(parent, onLeagueItemClick,listSelected)
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        val leagueItem = getItem(position)
        if (leagueItem != null) {
            holder.bind(leagueItem)
        }
    }
}