package com.nsolution.nfoodmerchant.Models

import android.net.Uri
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemReviewFoodDto {
  @SerializedName("foodId")
  @Expose
  var foodId: Int? = null

  @SerializedName("foodName")
  @Expose
  var foodName: String? = null

  @SerializedName("foodImage")
  @Expose
  var foodImage: Uri? = null

  @SerializedName("foodDiscription")
  @Expose
  var foodDiscription: String? = null

  @SerializedName("foodPrice")
  @Expose
  var foodPrice: Double? = null

  @SerializedName("categoryName")
  @Expose
  var categoryName: String? = null

  @SerializedName("categoryId")
  @Expose
  var categoryId: Int? = null
}