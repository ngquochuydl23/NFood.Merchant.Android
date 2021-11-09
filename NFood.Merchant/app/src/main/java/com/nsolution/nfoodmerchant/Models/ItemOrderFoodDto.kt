package com.nsolution.nfoodmerchant.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemOrderFoodDto {
  @SerializedName("id")
  @Expose
  var id: Int? = null

  @SerializedName("foodId")
  @Expose
  var foodId: Int? = null

  @SerializedName("foodName")
  @Expose
  var foodName: String? = null

  @SerializedName("quanlity")
  @Expose
  var quanlity: Int? = null

  @SerializedName("foodNote")
  @Expose
  var foodNote: String? = null

  @SerializedName("foodPrice")
  @Expose
  var foodPrice: Double? = null
}