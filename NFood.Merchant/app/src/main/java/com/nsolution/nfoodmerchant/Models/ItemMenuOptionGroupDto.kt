package com.nsolution.nfoodmerchant.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemMenuOptionGroupDto {
  @SerializedName("id")
  @Expose
  var id: Int? = null

  @SerializedName("optionGroupName")
  @Expose
  var optionGroupName: String? = null

  @SerializedName("listOption")
  @Expose
  var listOption: ArrayList<ItemMenuOptionDto>? = null
}