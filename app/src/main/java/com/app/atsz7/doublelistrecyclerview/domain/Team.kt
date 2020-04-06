package com.app.atsz7.doublelistrecyclerview.domain

data class Team(
    var image: Int,
    var name: String,
    var won: Int,
    var drawn: Int,
    var lost: Int,
    var position: Int
) {
    var points: Int = (won * 3) + drawn
}
