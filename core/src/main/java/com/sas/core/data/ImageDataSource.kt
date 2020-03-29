package com.sas.core.data

import com.sas.core.domain.Image

interface ImageDataSource {
    suspend fun getImages() : List<Image>
}