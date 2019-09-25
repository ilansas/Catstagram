package com.sas.data.retrofit

import com.sas.data.model.AddFavorite
import com.sas.data.model.Favorite
import com.sas.data.model.Image
import com.sas.data.model.PostResult
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
