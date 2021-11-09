package com.nsolution.nfoodmerchant.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemInboxDto {
  @SerializedName("id")
  @Expose
  var id: Int? = null

  @SerializedName("title")
  @Expose
  var title: String? = null

  @SerializedName("avatar")
  @Expose
  var avatar: String? = null

  @SerializedName("subTitle")
  @Expose
  var subtitle: String? = null

  @SerializedName("createdOn")
  @Expose
  var createdOn: String? = null
}