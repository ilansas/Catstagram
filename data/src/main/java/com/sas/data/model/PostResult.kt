package com.sas.data.model

import com.google.gson.annotations.SerializedName

data class PostResult(
    @SerializedName("message")
    val message: String
) {
    fun isSuccess() = message == "SUCCESS"
}