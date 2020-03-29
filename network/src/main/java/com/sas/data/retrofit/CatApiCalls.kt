package com.sas.data.retrofit

import com.sas.core.domain.AddFavorite
import com.sas.core.domain.Favorite
import com.sas.core.domain.Image
import com.sas.core.domain.PostResult
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface CatApiCalls {

    @GET("images/search")
    suspend fun getImages(@Query("limit") limit: Int = 3): List<Image>

    @POST("favourites")
    suspend fun addImageToFavorite(@Body addFavorite: AddFavorite): PostResult

    @GET("favourites")
    suspend fun getFavorites(@Query("page") page: Int, @Query("limit") limit: Int = 10): List<Favorite>

}
