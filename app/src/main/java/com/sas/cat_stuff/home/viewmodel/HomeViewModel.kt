package com.sas.cat_stuff.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sas.cat_stuff.common.viewmodel.BaseAndroidVM
import com.sas.cat_stuff.framework.NetworkImageDataSource
import com.sas.core.data.ImageRepository
import com.sas.core.domain.Image
import com.sas.core.interactors.GetImagesInteractor
import kotlinx.coroutines.launch

class HomeViewModel : BaseAndroidVM() {

    var images = MutableLiveData<List<Image>>()

    fun downloadRandomCatImages() {
        viewModelScope.launch {
            images.value = GetImagesInteractor(ImageRepository(NetworkImageDataSource()))()
        }
    }

    fun onShowMeMoreButtonClick() = downloadRandomCatImages()
}