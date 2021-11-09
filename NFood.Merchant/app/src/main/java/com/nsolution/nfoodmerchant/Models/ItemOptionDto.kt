package com.nsolution.nfoodmerchant.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ItemOptionDto : Serializable {
  @SerializedName("optionId")
  @Expose
  var optionId : Int? = null

  @SerializedName("optionName")
  @Expose
  var optionName : String? = null

  @SerializedName("optionPrice")
  @Expose
  var optionPrice : Double? = null

  @SerializedName("optionGroupId")
  @Expose
  var optionGroupId : Int? = null
}