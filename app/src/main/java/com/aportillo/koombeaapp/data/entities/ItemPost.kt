package com.aportillo.koombeaapp.data.entities

import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList

data class ItemPost (
  @SerializedName("id")
  val id: String,
  @SerializedName("date")
  val date: Date,
  @SerializedName("pics")
  val pics: ArrayList<String>

)