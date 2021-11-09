package com.nsolution.nfoodmerchant.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResultTokenDto {
  @SerializedName("token")
  @Expose
  var token : String? = null
}