package com.sas.cat_stuff.common

import androidx.lifecycle.MutableLiveData

open class BaseUpdatableVM<T> : BaseAndroidVM() {

    val data = MutableLiveData<T>()

    fun setData(obj: T) {
        data.value = obj
    }
}