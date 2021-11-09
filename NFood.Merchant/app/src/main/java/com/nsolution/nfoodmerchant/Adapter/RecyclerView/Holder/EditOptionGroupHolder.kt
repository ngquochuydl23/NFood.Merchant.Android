package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nsolution.nfoodmerchant.R

class EditOptionGroupHolder (itemView : View) : BaseHolder(itemView) {
  val optionGroupName = itemView.findViewById<TextView>(R.id.optionGroupName)
  val numberItemLinked = itemView.findViewById<TextView>(R.id.numberItemLinked)
  val containerLayout = itemView.findViewById<View>(R.id.containerLayout)
}