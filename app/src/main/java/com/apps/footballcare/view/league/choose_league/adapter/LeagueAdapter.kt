package com.apps.footballcare.view.league.choose_league.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.apps.footballcare.data.remote.model.League
import com.apps.footballcare.data.remote.model.Response

/**
 *
 * LeagueAdapter.kt.
 *
 * Created by thangtx on 11/27/21.
 *
 */
class LeagueAdapter : ListAdapter<Response, LeagueViewHolder>(LEAGUE_COMPARATOR) {
    /** Item Click Functions **/
     var onLeagueItemClick: ((List<Response>) -> Unit)? = null
    var listSelected = mutableListOf<Response>()

    companion object {
        private val LEAGUE_COMPARATOR = object : DiffUtil.ItemCallback<Response>() {
            override fun areItemsTheSame(oldItem: Response, newItem: Response): Boolean =
                oldItem.league == newItem.league

            override fun areContentsTheSame(oldItem: Response, newItem: Response): Boolean =
                oldItem.league == newItem.league
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