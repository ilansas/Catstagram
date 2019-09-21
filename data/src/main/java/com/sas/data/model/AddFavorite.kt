package com.sas.data.model

import com.google.gson.annotations.SerializedName

data class AddFavorite(
    @SerializedName("image_id")
    val imageId: String
)
