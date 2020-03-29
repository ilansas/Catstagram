package com.sas.core.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Image(
    @SerializedName("breeds")
    val breeds: List<Breed>? = null,

    @SerializedName("id")
    val id: String? = null,

    @SerializedName("url")
    val url: String? = null
) : Serializable