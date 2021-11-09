package com.nsolution.nfoodmerchant.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemOrderDto {
  @SerializedName("orderId")
  @Expose
  var orderId: String? = null

  @SerializedName("numberItems")
  @Expose
  var numberItems: Int? = null

  @SerializedName("customerName")
  @Expose
  var customerName: String? = null

  @SerializedName("driverAvatar")
  @Expose
  var driverAvatar: String? = null

  @SerializedName("maxTime")
  @Expose
  var maxTime: Long? = null

  @SerializedName("currentTime")
  @Expose
  var currentTime: Long? = null
}
