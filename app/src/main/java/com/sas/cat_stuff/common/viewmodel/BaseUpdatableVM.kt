package com.sas.cat_stuff.common.viewmodel

import androidx.lifecycle.MutableLiveData

open class BaseUpdatableVM<T> : BaseAndroidVM() {

    val data = MutableLiveData<T>()

    fun setData(obj: T?) {
        obj ?: return
        data.value = obj
    }
}