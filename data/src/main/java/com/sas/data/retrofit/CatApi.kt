package com.sas.data.retrofit

object CatApi {
    val api: CatApiCalls by lazy { CatApiBuilder().buildApi() }
}