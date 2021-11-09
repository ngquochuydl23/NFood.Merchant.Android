package com.nsolution.nfoodmerchant.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemEditOptionGroupDto {
  @SerializedName("id")
  @Expose
  var id: Int? = null

  @SerializedName("optionGroupName")
  @Expose
  var optionGroupName: String? = null

  @SerializedName("numberItemLinked")
  @Expose
  var numberItemLinked: Int? = null

  @SerializedName("listOption")
  @Expose
  var listOption: Int? = null
}