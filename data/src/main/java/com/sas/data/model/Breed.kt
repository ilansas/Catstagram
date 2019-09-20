package com.sas.data.model

import com.google.gson.annotations.SerializedName

data class Breed(
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("name")
    val name: String? = null
)