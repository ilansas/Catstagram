package com.sas.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
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
) : Parcelable