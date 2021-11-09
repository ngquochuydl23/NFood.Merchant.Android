package com.nsolution.nfoodmerchant.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemCategoryDto {
  @SerializedName("categoryId")
  @Expose
  var categoryId : Int? = null

  @SerializedName("categoryName")
  @Expose
  var categoryName : String? = null

  @SerializedName("numberItems")
  @Expose
  var numberItems : Int? = null

  @SerializedName("menu")
  @Expose
  var menu : String? = null
}