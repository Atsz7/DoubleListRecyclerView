package com.app.atsz7.doublelistrecyclerview.ui.adapters

import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.app.atsz7.doublelistrecyclerview.domain.Team
import com.app.atsz7.doublelistrecyclerview.extensions.setVisibility
import kotlinx.android.synthetic.main.item_teams_list.view.*

class TeamsHolder(view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        const val VIEW_TYPE = 84
    }

    fun bind(team: Team) = with(itemView) {

        txtTitle.setVisibility { team.position == 1 }
        tableWrapper.setVisibility { team.position == 1 }

        imgImage.setImageDrawable(
            AppCompatResources.getDrawable(context, team.image)
        )

        txtName.text = team.name
        txtWon.text = "${team.won}"
        txtDrawn.text = "${team.drawn}"
        txtLost.text = "${team.lost}"
        txtPoints.text = "${team.points}"
    }
}
