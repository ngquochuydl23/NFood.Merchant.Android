package com.nsolution.nfoodmerchant.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemTrendingFoodDto {
  @SerializedName("id")
  @Expose
  var id: Int? = null

  @SerializedName("foodName")
  @Expose
  var foodName: String? = null

  @SerializedName("categoryName")
  @Expose
  var categoryName: String? = null

  @SerializedName("foodImage")
  @Expose
  var foodImage: String? = null

  @SerializedName("foodPrice")
  @Expose
  var foodPrice: Double? = null

  @SerializedName("numberOrder")
  @Expose
  var numberOrder: Int? = null

  @SerializedName("foodId")
  @Expose
  var foodId: Int? = null
}