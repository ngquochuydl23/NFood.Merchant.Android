package com.nsolution.nfoodmerchant.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemSuggestPromotionDto {
  @SerializedName("Id")
  @Expose
  var id : Int? = null

  @SerializedName("Title")
  @Expose
  var title : String? = null

  @SerializedName("Subtitle")
  @Expose
  var subtitle : String? = null

  @SerializedName("Expiration")
  @Expose
  var expiration : String? = null

  @SerializedName("MinOrderPrice")
  @Expose
  var minOrderPrice : Double? = null
}