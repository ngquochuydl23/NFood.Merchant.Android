package com.nsolution.nfoodmerchant.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemMenuOptionDto {
  @SerializedName("optionId")
  @Expose
  var optionId : Int? = null

  @SerializedName("optionName")
  @Expose
  var optionName : String? = null

  @SerializedName("isOutOfStock")
  @Expose
  var isOutOfStock : Boolean? = null

  @SerializedName("optionGroupId")
  @Expose
  var optionGroupId : Int? = null
}