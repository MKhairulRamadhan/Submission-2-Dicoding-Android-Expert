package com.mkhairulramadhan.core.data.remote

import com.google.gson.annotations.SerializedName

data class MovieDataItem(
        @SerializedName("id")
        val id: Int,

        @SerializedName("title")
        val title: String? = null,

        @SerializedName("backdrop_path")
        val backdrop_path: String? = null,

        @SerializedName("poster_path")
        val poster_path: String? = null,

        @SerializedName("release_date")
        val release_date: String? = null,

        @SerializedName("vote_average")
        val vote_average: Double? = null,

        @SerializedName("original_language")
        val original_language: String? = null,

        @SerializedName("overview")
        val overview: String? = null
)