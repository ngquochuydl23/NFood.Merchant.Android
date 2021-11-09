package com.nsolution.nfoodmerchant.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemNewsDto {
  @SerializedName("newId")
  @Expose
  var newId : Int? = null

  @SerializedName("title")
  @Expose
  var title : String? = null

  @SerializedName("subTitle")
  @Expose
  var subTitle : String? = null

  @SerializedName("image")
  @Expose
  var image : String? = null

  @SerializedName("contentLink")
  @Expose
  var contentLink : String? = null
}