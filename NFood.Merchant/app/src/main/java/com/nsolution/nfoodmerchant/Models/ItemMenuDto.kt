package com.nsolution.nfoodmerchant.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ItemMenuDto : Serializable {
  @SerializedName("id")
  @Expose
  var id: Int? = null

  @SerializedName("menuTitle")
  @Expose
  var menuTitle: String? = null

  @SerializedName("menuAvailability")
  @Expose
  var menuAvailability: String? = null

  @SerializedName("numberCategories")
  @Expose
  var numberCategories: Int? = null

  @SerializedName("numberItems")
  @Expose
  var numberItems: Int? = null
}