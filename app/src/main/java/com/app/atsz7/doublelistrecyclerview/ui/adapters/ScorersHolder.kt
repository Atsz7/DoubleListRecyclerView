package com.app.atsz7.doublelistrecyclerview.ui.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.app.atsz7.doublelistrecyclerview.domain.Scorer
import com.app.atsz7.doublelistrecyclerview.extensions.setVisibility
import kotlinx.android.synthetic.main.item_scorers_list.view.*

class ScorersHolder(view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        const val VIEW_TYPE = 83
    }

    fun bind(scorer: Scorer) = with(itemView) {

        txtTitle.setVisibility { scorer.position == 1 }
        txtName.text = scorer.name
        txtGoals.text = "${scorer.goals}"
    }
}
