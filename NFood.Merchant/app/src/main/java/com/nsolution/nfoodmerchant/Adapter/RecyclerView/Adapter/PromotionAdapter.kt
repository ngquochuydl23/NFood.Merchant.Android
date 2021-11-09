package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter

import android.content.Intent
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder.PromotionHolder
import com.nsolution.nfoodmerchant.Models.ItemPromotionDto
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Promotions.PromotionDetail
import com.nsolution.nfoodmerchant.Ui.Promotions.PromotionSuggestDetail

class PromotionAdapter(val listPromotion: ArrayList<ItemPromotionDto>?) :
  BaseAdapter<PromotionHolder>() {

  private val PROMOTION_ID = "PROMOTION_ID"
  private val RUNNING = "RUNNING"
  private val ENDED = "ENDED"

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromotionHolder {
    val view = getView(parent, viewType, R.layout.item_promotion)
    return PromotionHolder(view)
  }

  override fun onBindViewHolder(holder: PromotionHolder, position: Int) {
    val itemPromotion = listPromotion?.get(position)

    holder.promoTitle.text = itemPromotion?.promoTitle
    holder.promoSubtitle.text = itemPromotion?.promoSubtitle
    holder.promoDate.text = itemPromotion?.promoDate

    holder.containerLayout.setOnClickListener {
      val intent = Intent(context, PromotionDetail::class.java)

      intent.putExtra(PROMOTION_ID, itemPromotion?.promoId)
      context.startActivity(intent)
    }

    val itemPromoStatus = itemPromotion?.promoStatus?.toUpperCase()
    holder.promoStatus.text = itemPromoStatus

    if (itemPromoStatus == RUNNING)
      setTextColor(holder.promoStatus, R.color.green)
    else if (itemPromoStatus == ENDED)
      setTextColor(holder.promoStatus, R.color.red)
    else
      setTextColor(holder.promoStatus, R.color.yellow)
  }

  private fun setTextColor(textView: TextView, color: Int) {
    textView.setTextColor(ContextCompat.getColor(context, color))
  }

  override fun getItemCount(): Int {
    return getSizeList(listPromotion)
  }
}