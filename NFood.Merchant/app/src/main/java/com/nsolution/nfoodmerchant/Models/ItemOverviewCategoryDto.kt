package com.nsolution.nfoodmerchant.Models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemOverviewCategoryDto() : Parcelable{
  @SerializedName("categoryId")
  @Expose
  var categoryId : Int? = null

  @SerializedName("categoryName")
  @Expose
  var categoryName : String? = null

  @SerializedName("foods")
  @Expose
  var foods : ArrayList<ItemMenuFoodDto>? = null

  constructor(parcel: Parcel) : this() {
    categoryId = parcel.readValue(Int::class.java.classLoader) as? Int
    categoryName = parcel.readString()
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeValue(categoryId)
    parcel.writeString(categoryName)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<ItemOverviewCategoryDto> {
    override fun createFromParcel(parcel: Parcel): ItemOverviewCategoryDto {
      return ItemOverviewCategoryDto(parcel)
    }

    override fun newArray(size: Int): Array<ItemOverviewCategoryDto?> {
      return arrayOfNulls(size)
    }
  }
}