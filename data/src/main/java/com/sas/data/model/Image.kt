package com.sas.data.model

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("breeds")
    val breeds: List<Breed>? = null,

    @SerializedName("id")
    val id: String? = null,

    @SerializedName("url")
    val url: String? = null
)