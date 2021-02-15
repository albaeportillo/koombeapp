package com.aportillo.koombeaapp.data.entities

import com.google.gson.annotations.SerializedName

data class Data (
    @SerializedName("uid")
    val uid: String,
    @SerializedName("name")
   val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("profile_pic")
    val profile_pic: String,
    @SerializedName("post")
     val post: ItemPost


)
//val post: List<Data> = query.execute().toObjects(::Data)