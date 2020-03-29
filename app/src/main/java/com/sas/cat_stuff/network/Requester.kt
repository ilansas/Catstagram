package com.sas.cat_stuff.network

import com.sas.core.domain.AddFavorite
import com.sas.core.domain.Favorite
import com.sas.core.domain.Image
import com.sas.data.retrofit.CatApi

object Requester {

    suspend fun getImages() = CatApi.api.getImages()

    suspend fun addImageToFavorite(image: Image) = CatApi.api.addImageToFavorite(AddFavorite(image.id))

    suspend fun getFavorites(page: Int, limit: Int) = CatApi.api.getFavorites(page, limit)
}