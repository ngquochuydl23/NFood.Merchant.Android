package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.TextView
import com.nsolution.nfoodmerchant.R

class SuggestPromotionHolder(itemView : View) : BaseHolder(itemView){
  val promoTitle = itemView.findViewById<TextView>(R.id.promoTitle)
  val promoSubtitle = itemView.findViewById<TextView>(R.id.promoSubtitle)
  val promoMinOrderPrice = itemView.findViewById<TextView>(R.id.promoMinOrderPrice)
  val promoExpiration = itemView.findViewById<TextView>(R.id.promoExpiration)
  val usePromoButton = itemView.findViewById<TextView>(R.id.usePromoButton)
  val containerLayout = itemView.findViewById<View>(R.id.containerLayout)
}