package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.mikhaellopez.circularprogressbar.CircularProgressBar
import com.nsolution.nfoodmerchant.R

class OrderHolder(itemView : View) : BaseHolder(itemView) {
  val orderId = itemView.findViewById<TextView>(R.id.orderId)
  val numberItemForCustomer = itemView.findViewById<TextView>(R.id.numberItemForCustomer)
  val timeToAccepOrder = itemView.findViewById<TextView>(R.id.timeToAccepOrder)
  val driverAvatar = itemView.findViewById<ImageView>(R.id.driverAvatar)
  val progressTimeAcceptOrder = itemView.findViewById<CircularProgressBar>(R.id.progressTimeAcceptOrder)
  val subTimeToAcceptOrder = itemView.findViewById<TextView>(R.id.subTimeToAcceptOrder)
  val containerLayout = itemView.findViewById<View>(R.id.containerLayout)
}