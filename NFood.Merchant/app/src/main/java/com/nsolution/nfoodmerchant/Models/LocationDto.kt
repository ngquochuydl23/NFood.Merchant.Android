package com.nsolution.nfoodmerchant.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class LocationDto : Serializable {
  @SerializedName("address")
  @Expose
  var address: String? = null

  @SerializedName("detailAddress")
  @Expose
  var detailAddress: String? = null

  @SerializedName("latitude")
  @Expose
  var latitude: Double? = null

  @SerializedName("longitude")
  @Expose
  var longitude: Double? = null
}