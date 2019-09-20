package com.sas.data.retrofit

import com.sas.data.model.Breed
import com.sas.data.model.Image
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApiCalls {

    @GET("breeds")
    suspend fun getBreeds(@Query("page") page: Int, @Query("limit") limit: Int = 10): List<Breed>

    @GET("images/search")
    suspend fun getImages(@Query("limit") limit: Int = 3): List<Image>
}
