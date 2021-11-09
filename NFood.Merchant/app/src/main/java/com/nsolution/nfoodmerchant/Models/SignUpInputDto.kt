package com.nsolution.nfoodmerchant.Models

import com.google.gson.annotations.SerializedName

data class SignUpInputDto(
  @SerializedName("Email")
  val Email : String,
  @SerializedName("Password")
  val Password : String,
)