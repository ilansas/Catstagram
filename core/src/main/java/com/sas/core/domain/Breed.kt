package com.sas.core.domain

import com.google.gson.annotations.SerializedName

data class Breed(
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("description")
    val description: String? = null,

    @SerializedName("origin")
    val origin: String? = null,

    @SerializedName("wikipedia_url")
    val wikipediaUrl: String? = null
)