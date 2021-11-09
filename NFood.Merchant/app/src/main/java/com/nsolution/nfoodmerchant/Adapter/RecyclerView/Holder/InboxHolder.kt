package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.nsolution.nfoodmerchant.R

class InboxHolder(itemView: View) : BaseHolder(itemView) {
  val title = itemView.findViewById<TextView>(R.id.title)
  val avatar = itemView.findViewById<ImageView>(R.id.avatar)
  val subtitle = itemView.findViewById<TextView>(R.id.subtitle)
  val createdOn = itemView.findViewById<TextView>(R.id.createdOn)
  val containerLayout = itemView.findViewById<View>(R.id.containerLayout)
}