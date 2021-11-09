package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.TextView
import com.nsolution.nfoodmerchant.R

class CategoryHolder (itemView: View) : BaseHolder(itemView) {
  val categoryName = itemView.findViewById<TextView>(R.id.categoryName)
  val menuAndNumberItems = itemView.findViewById<TextView>(R.id.menuAndNumberItems)
  val containerLayout = itemView.findViewById<View>(R.id.containerLayout)
}