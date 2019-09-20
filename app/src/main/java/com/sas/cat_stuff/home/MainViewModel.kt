package com.sas.cat_stuff.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sas.cat_stuff.common.BaseAndroidVM
import com.sas.cat_stuff.network.Requester
import com.sas.data.model.Image
import kotlinx.coroutines.launch

class MainViewModel : BaseAndroidVM() {

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