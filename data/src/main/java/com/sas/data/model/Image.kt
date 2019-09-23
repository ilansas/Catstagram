package com.sas.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(
    @SerializedName("breeds")
    val breeds: List<Breed>? = null,

    @SerializedName("id")
    val id: String? = null,

    @SerializedName("url")
    val url: String? = null
) : Parcelable