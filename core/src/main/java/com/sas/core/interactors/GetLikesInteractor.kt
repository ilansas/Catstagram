package com.sas.core.interactors

import com.sas.core.data.LikeRepository

class GetLikesInteractor(private val likeRepository: LikeRepository) {

    suspend operator fun invoke(page: Int, limit: Int) = likeRepository.getAll(page, limit)
}