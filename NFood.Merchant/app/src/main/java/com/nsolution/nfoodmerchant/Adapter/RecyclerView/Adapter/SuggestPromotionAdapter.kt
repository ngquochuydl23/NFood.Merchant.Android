package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter

import android.content.Intent
import android.view.ViewGroup
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder.SuggestPromotionHolder
import com.nsolution.nfoodmerchant.Models.ItemSuggestPromotionDto
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Currency.FormatCurrency
import com.nsolution.nfoodmerchant.Ui.Promotions.PromotionSuggestDetail

class SuggestPromotionAdapter(val listSuggestPromotion: ArrayList<ItemSuggestPromotionDto>?) :
  BaseAdapter<SuggestPromotionHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestPromotionHolder {
    val view = getView(parent, viewType, R.layout.item_suggest_promotion)
    return SuggestPromotionHolder(view)
  }

  override fun onBindViewHolder(holder: SuggestPromotionHolder, position: Int) {
    val itemSuggestPromotion = listSuggestPromotion?.get(position)

    val minOrderPrice = FormatCurrency.FormatCurrencyVietNam(itemSuggestPromotion?.minOrderPrice)


    holder.promoTitle.text = itemSuggestPromotion?.title
    holder.promoSubtitle.text = itemSuggestPromotion?.subtitle
    holder.promoExpiration.text = itemSuggestPromotion?.expiration
    holder.promoMinOrderPrice.text = "Giá trị đơn hàng tối thiểu " + minOrderPrice

    holder.containerLayout.setOnClickListener {
      val intent = Intent(context, PromotionSuggestDetail::class.java)
      context.startActivity(intent)
    }

    holder.usePromoButton.setOnClickListener {

    }
  }

  override fun getItemCount(): Int {
    return getSizeList(listSuggestPromotion)
  }
}