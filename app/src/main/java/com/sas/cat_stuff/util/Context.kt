package com.sas.cat_stuff.util

import android.content.Context
import android.content.ContextWrapper
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity

fun Context.scanForActivity(): AppCompatActivity? = when (this) {
    is AppCompatActivity -> this
    is ContextWrapper -> baseContext.scanForActivity()
    else -> null
}

fun Context.layoutInflater() = LayoutInflater.from(this)