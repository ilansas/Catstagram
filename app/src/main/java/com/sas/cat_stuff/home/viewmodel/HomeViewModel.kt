package com.sas.cat_stuff.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sas.cat_stuff.common.viewmodel.BaseAndroidVM
import com.sas.cat_stuff.network.Requester
import com.sas.data.model.Image
import kotlinx.coroutines.launch

class HomeViewModel : BaseAndroidVM() {

    var images = MutableLiveData<List<Image>>()

    fun downloadRandomCatImages() {
        viewModelScope.launch {
            images.value = Requester.getImages()
        }
    }

    fun onShowMeMoreButtonClick() {
        downloadRandomCatImages()
    }
}