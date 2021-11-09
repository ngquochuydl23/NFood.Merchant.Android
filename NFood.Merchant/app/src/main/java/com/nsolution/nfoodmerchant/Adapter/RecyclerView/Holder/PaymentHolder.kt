package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.TextView
import com.nsolution.nfoodmerchant.R

class PaymentHolder(itemView : View) : BaseHolder(itemView){
  val paymentTitle = itemView.findViewById<TextView>(R.id.paymentTitle)
  val paymentDate = itemView.findViewById<TextView>(R.id.paymentDate)
  val paymentCost = itemView.findViewById<TextView>(R.id.paymentCost)
  val containerLayout = itemView.findViewById<View>(R.id.containerLayout)
}