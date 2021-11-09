package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.nsolution.nfoodmerchant.R

class PromotionHolder(itemView : View) : BaseHolder(itemView) {
  val promoImage = itemView.findViewById<ImageView>(R.id.promoImage)
  val promoTitle = itemView.findViewById<TextView>(R.id.promoTitle)
  val promoSubtitle = itemView.findViewById<TextView>(R.id.promoSubtitle)
  val promoDate = itemView.findViewById<TextView>(R.id.promoDate)
  val containerLayout = itemView.findViewById<View>(R.id.containerLayout)
  val promoStatus = itemView.findViewById<TextView>(R.id.promoStatus)
}