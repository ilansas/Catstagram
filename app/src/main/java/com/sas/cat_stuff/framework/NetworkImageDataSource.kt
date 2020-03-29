package com.sas.cat_stuff.framework

import com.sas.cat_stuff.network.Requester
import com.sas.core.data.ImageDataSource
import com.sas.core.domain.Image

class NetworkImageDataSource : ImageDataSource {

    override suspend fun getImages(): List<Image> = Requester.getImages()
}