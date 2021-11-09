package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.TextView
import com.nsolution.nfoodmerchant.R

class OrderFoodHolder(val itemView: View) : BaseHolder(itemView) {
  val foodName = itemView.findViewById<TextView>(R.id.foodName)
  val foodNote = itemView.findViewById<TextView>(R.id.foodNote)
  val foodCost = itemView.findViewById<TextView>(R.id.foodCost)
  val quanlity = itemView.findViewById<TextView>(R.id.quanlity)
  val containerLayout = itemView.findViewById<View>(R.id.containerLayout)
}