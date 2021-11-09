package com.nsolution.nfoodmerchant.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemWorkTimeDto {
  @SerializedName("id")
  @Expose
  var id: Int? = null

  @SerializedName("dayOfWeek")
  @Expose
  var dayOfWeek: String? = null

  @SerializedName("workTime")
  @Expose
  var workTime: String? = null
}