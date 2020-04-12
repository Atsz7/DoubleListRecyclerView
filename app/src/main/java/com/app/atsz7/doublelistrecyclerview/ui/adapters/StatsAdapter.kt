package com.app.atsz7.doublelistrecyclerview.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.atsz7.doublelistrecyclerview.*
import com.app.atsz7.doublelistrecyclerview.domain.Scorer
import com.app.atsz7.doublelistrecyclerview.domain.Team

class StatsAdapter(private val scorers: List<Scorer>, private val teams: List<Team>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        /**
         * We inflate and create the instance of the view
         * holder depending on the type of view we
         * received as parameter ([viewType]).
         */
        return if (viewType == ScorersHolder.VIEW_TYPE) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_scorers_list, parent, false)
            ScorersHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_teams_list, parent, false)
            TeamsHolder(view)
        }
    }

    /**
     * We add the size of both lists and return it.
     * @return [Int].
     */
    override fun getItemCount() = scorers.size + teams.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        /**
         * We validate the type of [holder] we receive
         * as parameter and obtain the item from the
         * appropriate list, remembering if the list
         * we want to access is [teams] we have to
         * recalculate the position.
         */
        when (holder) {
            is ScorersHolder -> holder.bind(scorers[position])
            is TeamsHolder -> holder.bind(teams[(position - scorers.size)])
        }
    }

    override fun getItemViewType(position: Int): Int {

        /**
         * If the current position is less than the size of the
         * list [scorers] then we know which object belongs to
         * the list [scorers] and we must return a view type
         * [ScorersHolder.VIEW_TYPE].
         */
        if (position < scorers.size) {
            return ScorersHolder.VIEW_TYPE
        }

        /**
         * At this point, we know that the object does not belong
         * to the [scorers] list, so we have to recalculate the
         * position by subtracting the size of the [scorers]
         * list from the value of [position], then we do the
         * same validation as before but now with the [teams]
         * list. If the object belongs to the list of [teams],
         * we must return a view type [TeamsHolder.VIEW_TYPE].
         */
        val realPosition = (position - scorers.size)
        if (realPosition < teams.size) {
            return TeamsHolder.VIEW_TYPE
        }

        return -1
    }
}
