package com.sas.cat_stuff.util

import androidx.databinding.BindingAdapter
import com.sas.cat_stuff.home.DoubleClickCardView

@BindingAdapter("onDoubleClick")
fun DoubleClickCardView.onDoubleClick(onDoubleClickListener: DoubleClickCardView.OnDoubleClickListener?) {
    setOnDoubleClickListener(onDoubleClickListener)
}