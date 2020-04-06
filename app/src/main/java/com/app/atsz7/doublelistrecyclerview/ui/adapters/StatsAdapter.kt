package com.app.atsz7.doublelistrecyclerview.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.atsz7.doublelistrecyclerview.*
import com.app.atsz7.doublelistrecyclerview.domain.Scorer
import com.app.atsz7.doublelistrecyclerview.domain.Team

class StatsAdapter(private val scorers: List<Scorer>, private val teams: List<Team>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (viewType == ScorersHolder.VIEW_TYPE) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_scorers_list, parent, false)
            ScorersHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_teams_list, parent, false)
            TeamsHolder(view)
        }
    }

    override fun getItemCount() = scorers.size + teams.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is ScorersHolder -> holder.bind(scorers[position])
            is TeamsHolder -> holder.bind(teams[(position - scorers.size)])
        }
    }

    override fun getItemViewType(position: Int): Int {

        if (position < scorers.size) {
            return ScorersHolder.VIEW_TYPE
        }

        val realPosition = (position - scorers.size)
        if (realPosition < teams.size) {
            return TeamsHolder.VIEW_TYPE
        }

        return -1
    }
}
