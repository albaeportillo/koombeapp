package com.aportillo.koombeaapp.data.entities

import com.google.gson.annotations.SerializedName

data class DataList (
    @SerializedName("data")
    val data: List<Data>
)
