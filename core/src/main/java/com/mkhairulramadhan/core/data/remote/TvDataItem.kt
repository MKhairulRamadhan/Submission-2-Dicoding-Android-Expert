package com.mkhairulramadhan.core.data.remote

import com.google.gson.annotations.SerializedName

data class TvDataItem(
        @SerializedName("id")
        val id: Int,

        @SerializedName("name")
        val name: String? = null,

        @SerializedName("backdrop_path")
        val backdrop_path: String? = null,

        @SerializedName("poster_path")
        val poster_path: String? = null,

        @SerializedName("first_air_date")
        val first_air_date: String? = null,

        @SerializedName("vote_average")
        val vote_average: Double? = null,

        @SerializedName("original_language")
        val original_language: String? = null,

        @SerializedName("overview")
        val overview: String? = null
)