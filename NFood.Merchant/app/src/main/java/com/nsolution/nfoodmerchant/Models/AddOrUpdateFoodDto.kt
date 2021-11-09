package com.nsolution.nfoodmerchant.Models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AddOrUpdateFoodDto(
  @SerializedName("idFood")
  val idFood: Int? = null,

  @SerializedName("foodName")
  val foodName: String? = null,

  @SerializedName("foodImage")
  val foodImage: String? = null,

  @SerializedName("foodDiscription")
  val foodDiscription: String? = null,

  @SerializedName("foodPrice")
  val foodPrice: Double? = null,

  @SerializedName("categoryId")
  val categoryId: Int? = null,

  @SerializedName("category")
  val category: String? = null
) : Serializable