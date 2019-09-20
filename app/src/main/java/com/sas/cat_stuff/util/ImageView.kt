package com.sas.cat_stuff.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("url")
fun ImageView.loadImageFromUrl(url: String?) {
    url ?: return
    Glide.with(context).load(url).into(this)
}