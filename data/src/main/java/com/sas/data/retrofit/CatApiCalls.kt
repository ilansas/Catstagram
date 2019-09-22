package com.sas.data.retrofit

import com.sas.data.model.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface CatApiCalls {

    @GET("breeds")
    suspend fun getBreeds(@Query("page") page: Int, @Query("limit") limit: Int = 10): List<Breed>

    @GET("images/search")
    suspend fun getImages(@Query("limit") limit: Int = 3): List<Image>

    @POST("favourites")
    suspend fun addImageToFavorite(@Body addFavorite: AddFavorite): PostResult

    @GET("favourites")
    suspend fun getFavorites(@Query("page") page: Int, @Query("limit") limit: Int = 10): List<Favorite>

}
