package com.nsolution.nfoodmerchant.Models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AddOrUpdateCategoryDto(
  @SerializedName("categoryName")
  val categoryName: String?
) : Parcelable {
  constructor(parcel: Parcel) : this(parcel.readString()) {
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeString(categoryName)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<AddOrUpdateCategoryDto> {
    override fun createFromParcel(parcel: Parcel): AddOrUpdateCategoryDto {
      return AddOrUpdateCategoryDto(parcel)
    }

    override fun newArray(size: Int): Array<AddOrUpdateCategoryDto?> {
      return arrayOfNulls(size)
    }
  }

}