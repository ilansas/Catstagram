package com.sas.cat_stuff.common

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.sas.cat_stuff.CatApplication

open class BaseAndroidVM : AndroidViewModel(CatApplication.APP) {

    inline fun <D, Y> LiveData<D>.map(crossinline func: (d: D) -> Y): LiveData<Y> =
        Transformations.map(this) { func(it) }
}