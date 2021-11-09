package com.nsolution.nfoodmerchant.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemPromotionDto {
  @SerializedName("promoId")
  @Expose
  var promoId: Int? = null

  @SerializedName("promoTitle")
  @Expose
  var promoTitle: String? = null

  @SerializedName("promoSubtitle")
  @Expose
  var promoSubtitle: String? = null

  @SerializedName("promoDate")
  @Expose
  var promoDate: String? = null

  @SerializedName("promoStatus")
  @Expose
  var promoStatus: String? = null
}