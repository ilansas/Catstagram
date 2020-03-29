package com.sas.core.data

class ImageRepository(private val dataSource: ImageDataSource) {

    suspend fun getImages() = dataSource.getImages()
}