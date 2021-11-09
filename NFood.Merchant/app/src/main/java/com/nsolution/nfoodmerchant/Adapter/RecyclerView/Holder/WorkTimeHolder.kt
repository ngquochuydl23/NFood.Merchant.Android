package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.TextView
import com.nsolution.nfoodmerchant.R

class WorkTimeHolder(itemView: View) : BaseHolder(itemView) {
  val dayOfWeek = itemView.findViewById<TextView>(R.id.dayOfWeek)
  val workTime = itemView.findViewById<TextView>(R.id.workTime)
  val editWorkTime = itemView.findViewById<View>(R.id.editWorkTime)
}