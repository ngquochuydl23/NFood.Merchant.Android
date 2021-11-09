package com.nsolution.nfoodmerchant.Models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ItemMenuFoodDto() : Parcelable{
  @SerializedName("foodId")
  @Expose
  var foodId : Int? = null

  @SerializedName("foodName")
  @Expose
  var foodName : String? = null

  @SerializedName("foodImage")
  @Expose
  var foodImage : String? = null

  @SerializedName("foodDiscription")
  @Expose
  var foodDiscription : String? = null

  @SerializedName("foodPrice")
  @Expose
  var foodPrice : Double? = null

  @SerializedName("foodManagement")
  @Expose
  var foodManagement : FoodManagement? = null

  inner class FoodManagement {
    @SerializedName("isSoldOut")
    @Expose
    var isSoldOut : Boolean = false

    @SerializedName("typeSoldOut")
    @Expose
    var typeSoldOut : String? = null
  }

  @SerializedName("categoryId")
  @Expose
  var categoryId : Int? = null

  constructor(parcel: Parcel) : this() {
    foodId = parcel.readValue(Int::class.java.classLoader) as? Int
    foodName = parcel.readString()
    foodImage = parcel.readString()
    foodDiscription = parcel.readString()
    foodPrice = parcel.readValue(Double::class.java.classLoader) as? Double
    categoryId = parcel.readValue(Int::class.java.classLoader) as? Int
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeValue(foodId)
    parcel.writeString(foodName)
    parcel.writeString(foodImage)
    parcel.writeString(foodDiscription)
    parcel.writeValue(foodPrice)
    parcel.writeValue(categoryId)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<ItemMenuFoodDto> {
    override fun createFromParcel(parcel: Parcel): ItemMenuFoodDto {
      return ItemMenuFoodDto(parcel)
    }

    override fun newArray(size: Int): Array<ItemMenuFoodDto?> {
      return arrayOfNulls(size)
    }
  }
}