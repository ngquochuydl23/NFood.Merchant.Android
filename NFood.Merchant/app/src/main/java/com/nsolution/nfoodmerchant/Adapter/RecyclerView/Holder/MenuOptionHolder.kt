package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.Switch
import android.widget.TextView
import com.nsolution.nfoodmerchant.R

class MenuOptionHolder (itemView : View) : BaseHolder(itemView) {
  val optionName = itemView.findViewById<TextView>(R.id.optionName)
  val switchOutOfStock = itemView.findViewById<Switch>(R.id.switchOutOfStock)
}