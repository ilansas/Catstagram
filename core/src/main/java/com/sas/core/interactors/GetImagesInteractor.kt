package com.sas.core.interactors

import com.sas.core.data.ImageRepository

class GetImagesInteractor(private val imageRepository: ImageRepository) {

    suspend operator fun invoke() = imageRepository.getImages()
}