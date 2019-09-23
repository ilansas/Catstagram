package com.sas.cat_stuff.util

import android.view.View
import androidx.databinding.BindingAdapter
import com.sas.cat_stuff.home.card.view.DoubleClickCardView

@BindingAdapter("onDoubleClick")
fun DoubleClickCardView.onDoubleClick(onDoubleClickListener: DoubleClickCardView.OnDoubleClickListener?) {
    setOnDoubleClickListener(onDoubleClickListener)
}

@BindingAdapter("visibleOrGone")
fun View.setVisibleOrGone(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}