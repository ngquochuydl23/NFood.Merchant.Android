package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import com.nsolution.nfoodmerchant.R

class MenuFoodHolder(itemView : View) : BaseHolder(itemView) {
  val foodName = itemView.findViewById<TextView>(R.id.foodName)
  val foodImage = itemView.findViewById<ImageView>(R.id.foodImage)
  val foodPrice = itemView.findViewById<TextView>(R.id.foodPrice)
  val foodStatus = itemView.findViewById<TextView>(R.id.foodStatus)
  val switchOutOfStock = itemView.findViewById<Switch>(R.id.switchOutOfStock)
  val containerLayout = itemView.findViewById<View>(R.id.containerLayout)
  val editFoodButton = itemView.findViewById<View>(R.id.editFoodButton)
}