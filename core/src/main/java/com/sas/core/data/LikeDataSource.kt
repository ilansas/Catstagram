package com.sas.core.data

import com.sas.core.domain.Favorite
import com.sas.core.domain.Image
import com.sas.core.domain.PostResult

interface LikeDataSource {

    suspend fun getAll(page: Int, limit: Int): List<Favorite>

    suspend fun add(image: Image): PostResult
}