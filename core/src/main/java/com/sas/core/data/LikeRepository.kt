package com.sas.core.data

import com.sas.core.domain.Favorite
import com.sas.core.domain.Image

class LikeRepository(private val dataSource: LikeDataSource) {

    suspend fun getAll(page: Int, limit: Int) = dataSource.getAll(page, limit)

    suspend fun add(image: Image) = dataSource.add(image)
}