package com.sas.core.domain

import com.google.gson.annotations.SerializedName

data class PostResult(
    @SerializedName("message")
    val message: String
) {
    fun isSuccess() = message == "SUCCESS"
}