package com.sas.cat_stuff.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("url")
fun ImageView.loadImageFromUrl(url: String?) = url?.let {
    Glide.with(context).load(it).into(this)
}