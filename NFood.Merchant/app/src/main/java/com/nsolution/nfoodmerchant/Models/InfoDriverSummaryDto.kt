package com.nsolution.nfoodmerchant.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class InfoDriverSummaryDto {
  @SerializedName("driverId")
  @Expose
  var driverId: Int? = null

  @SerializedName("driverName")
  @Expose
  var driverName : String? = null

  @SerializedName("driverAvatar")
  @Expose
  var driverAvatar : String? = null

  @SerializedName("driverPhoneNumber")
  @Expose
  var driverPhoneNumber : String? = null
}