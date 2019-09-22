package com.sas.cat_stuff.common.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.sas.cat_stuff.application.CatApplication

open class BaseAndroidVM : AndroidViewModel(CatApplication.APP) {

    fun getContext() = getApplication<CatApplication>()

    inline fun <D, Y> LiveData<D>.map(crossinline func: (d: D) -> Y): LiveData<Y> =
        Transformations.map(this) { func(it) }
}