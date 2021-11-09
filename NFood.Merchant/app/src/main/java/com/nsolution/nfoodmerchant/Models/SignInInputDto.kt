package com.nsolution.nfoodmerchant.Models

import com.google.gson.annotations.SerializedName

data class SignInInputDto(
  @SerializedName("Email")
  val Email : String,
  @SerializedName("Password")
  val Password : String,
)