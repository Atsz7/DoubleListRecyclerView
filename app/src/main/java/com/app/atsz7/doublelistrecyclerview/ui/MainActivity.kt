package com.app.atsz7.doublelistrecyclerview.ui

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.atsz7.doublelistrecyclerview.R
import com.app.atsz7.doublelistrecyclerview.domain.Scorer
import com.app.atsz7.doublelistrecyclerview.domain.Team
import com.app.atsz7.doublelistrecyclerview.ui.adapters.StatsAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter: StatsAdapter by lazy {
        StatsAdapter(getScorers(), getTeams())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
            addItemDecoration(object : RecyclerView.ItemDecoration() {

                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    outRect.bottom = 15
                    outRect.top = 15
                }
            })
        }
    }

    /**
     * This method is used to create and return a dummy
     * list of scorers.
     * @return [List].
     */
    private fun getScorers() : List<Scorer> {

        return ArrayList<Scorer>().apply {
            add(Scorer("Arun Wickens", 15, 1))
            add(Scorer("Miles Currie", 10, 2))
            add(Scorer("Giovanni Welch", 7, 3))
        }
    }

    /**
     * This method is used to create and return a dummy
     * list of teams.
     * @return [List].
     */
    private fun getTeams() : List<Team> {

        return ArrayList<Team>().apply {
            add(
                Team(
                    R.drawable.ic_lions,
                    "Lions",
                    10,
                    0,
                    0,
                    1
                )
            )
            add(
                Team(
                    R.drawable.ic_tigers,
                    "Tigers",
                    9,
                    1,
                    0,
                    2
                )
            )
            add(
                Team(
                    R.drawable.ic_eagles,
                    "Eagles",
                    8,
                    1,
                    1,
                    3
                )
            )
            add(
                Team(
                    R.drawable.ic_foxes,
                    "Foxes",
                    7,
                    0,
                    3,
                    4
                )
            )
            add(
                Team(
                    R.drawable.ic_bulls,
                    "Bulls",
                    5,
                    2,
                    3,
                    5
                )
            )
        }
    }
}
