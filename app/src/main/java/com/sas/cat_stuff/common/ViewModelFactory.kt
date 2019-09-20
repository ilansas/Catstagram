package com.sas.cat_stuff.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sas.cat_stuff.BaseAndroidVM

object ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        if (modelClass.isAssignableFrom(BaseAndroidVM::class.java)) modelClass.newInstance()
        else super.create(modelClass)
}