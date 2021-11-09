package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.TextView
import com.nsolution.nfoodmerchant.R

class CreateOptionHolder(itemView : View) : BaseHolder(itemView) {
  val optionName = itemView.findViewById<TextView>(R.id.optionName)
  val optionPrice = itemView.findViewById<TextView>(R.id.optionPrice)
  val containerLayout = itemView.findViewById<View>(R.id.containerLayout)
}