package com.sas.cat_stuff.home.bottomsheet

import com.sas.cat_stuff.R
import com.sas.cat_stuff.common.viewmodel.BaseUpdatableVM
import com.sas.data.model.Image

class InfosBottomSheetVM : BaseUpdatableVM<Image>() {

    val imageUrl = data.map { it.url }

    val name = data.map { it.breeds!![0].name }

    val description = data.map { getDescription() }

    val localisation = data.map { getContext().getString(R.string.from_X, it.breeds!![0].origin) }

    val wikipediaUrl = data.map { it.breeds!![0].wikipediaUrl }

    fun getDescription(): String? {
        return data.value?.breeds!![0].description
    }

    fun onWikipediaClick() {

    }
}