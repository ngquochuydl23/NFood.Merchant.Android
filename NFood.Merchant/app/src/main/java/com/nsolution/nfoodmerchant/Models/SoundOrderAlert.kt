package com.nsolution.nfoodmerchant.Models

import com.google.gson.annotations.SerializedName

data class SoundOrderAlert(
  @SerializedName("id")
  val id: Int?,
  @SerializedName("soundRes")
  val soundRes: Int?
)