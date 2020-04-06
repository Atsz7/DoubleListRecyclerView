package com.app.atsz7.doublelistrecyclerview.extensions

import android.view.View

/**
 * This method is used to get the [View] visibility
 * depending of [validation] return value.
 * @return [Int].
 */
fun View.setVisibility(onTrue: Int = View.VISIBLE,
                       onFalse: Int = View.GONE,
                       validation: () -> Boolean) {

    this.visibility = if (validation()) {
        onTrue
    } else {
        onFalse
    }
}