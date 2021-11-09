package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import com.nsolution.nfoodmerchant.R

class SelectCategoryHolder(itemView : View) : BaseHolder(itemView) {
  val categoryName = itemView.findViewById<TextView>(R.id.categoryName)
  val isSelected = itemView.findViewById<RadioButton>(R.id.isSelected)
  val selectButton = itemView.findViewById<View>(R.id.selectButton)
}