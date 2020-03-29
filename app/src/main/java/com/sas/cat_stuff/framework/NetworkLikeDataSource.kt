package com.sas.cat_stuff.framework

import com.sas.cat_stuff.network.Requester
import com.sas.core.data.LikeDataSource
import com.sas.core.domain.Favorite
import com.sas.core.domain.Image

class NetworkLikeDataSource : LikeDataSource {
    override suspend fun getAll(page: Int, limit: Int): List<Favorite> = Requester.getFavorites(page, limit)

    override suspend fun add(image: Image) = Requester.addImageToFavorite(image)
}