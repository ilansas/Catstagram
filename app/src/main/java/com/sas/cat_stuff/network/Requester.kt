package com.sas.cat_stuff.network

import com.sas.data.retrofit.CatApi

object Requester {

    suspend fun fetch() = CatApi.api.getBreeds(0)
}