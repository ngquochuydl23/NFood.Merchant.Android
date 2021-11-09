package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.TextView
import com.nsolution.nfoodmerchant.R

class MenuHolder(itemView: View) : BaseHolder(itemView) {
  val containerLayout = itemView.findViewById<View>(R.id.containerLayout)
  val menuTitle = itemView.findViewById<TextView>(R.id.menuTitle)
  val menuAvailability = itemView.findViewById<TextView>(R.id.menuAvailability)
  val numberItems = itemView.findViewById<TextView>(R.id.numberItems)
  val numberCategories = itemView.findViewById<TextView>(R.id.numberCategories)
}