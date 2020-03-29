package com.sas.core.domain

import com.google.gson.annotations.SerializedName

data class Favorite(
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("image")
    val image: Image? = null
)