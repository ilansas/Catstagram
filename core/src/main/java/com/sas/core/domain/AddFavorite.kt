package com.sas.core.domain

import com.google.gson.annotations.SerializedName

data class AddFavorite(
    @SerializedName("image_id")
    val imageId: String? = null
)
