package com.sas.core.interactors

import com.sas.core.data.LikeRepository
import com.sas.core.domain.Favorite
import com.sas.core.domain.Image

class AddLikeInteractor(private val likeRepository: LikeRepository) {

    suspend operator fun invoke(image: Image) = likeRepository.add(image)
}