package com.sas.cat_stuff.home.bottomsheet

import android.content.Context
import com.sas.cat_stuff.R
import com.sas.cat_stuff.common.viewmodel.BaseUpdatableVM
import com.sas.cat_stuff.webview.WebviewActivity
import com.sas.data.model.Image

class InfosBottomSheetVM : BaseUpdatableVM<Image>() {

    val imageUrl = data.map { it.url }

    val name = data.map { it.breeds!![0].name }

    val description = data.map { it.breeds!![0].description }

    val localisation = data.map { getContext().getString(R.string.from_X, it.breeds!![0].origin) }

    val wikipediaUrl = data.map { it.breeds!![0].wikipediaUrl }

    fun onWikipediaClick(context: Context) = data.value?.breeds?.get(0)?.wikipediaUrl?.let {
        WebviewActivity.openActivity(context, it)
    }
}