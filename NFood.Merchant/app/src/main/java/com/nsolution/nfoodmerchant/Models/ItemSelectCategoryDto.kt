package com.nsolution.nfoodmerchant.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemSelectCategoryDto {
  @SerializedName("categoryId")
  @Expose
  var categoryId : Int? = null

  @SerializedName("categoryName")
  @Expose
  var categoryName : String? = null
}