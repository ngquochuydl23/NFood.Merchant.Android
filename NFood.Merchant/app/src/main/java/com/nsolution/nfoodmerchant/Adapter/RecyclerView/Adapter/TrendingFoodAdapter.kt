package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder.TrendingFoodHolder
import com.nsolution.nfoodmerchant.Models.ItemTrendingFoodDto
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Currency.FormatCurrency

class TrendingFoodAdapter(val listTrending : ArrayList<ItemTrendingFoodDto>?) : BaseAdapter<TrendingFoodHolder>(){

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingFoodHolder {
    val view = getView(parent,viewType, R.layout.item_trending_food)
    return TrendingFoodHolder(view)
  }

  @SuppressLint("SetTextI18n")
  override fun onBindViewHolder(holder: TrendingFoodHolder, position: Int) {
    val itemTrending = listTrending?.get(position)

    setImage(holder.foodImage,itemTrending?.foodImage)
    holder.foodName.text = itemTrending?.foodName
    holder.foodPrice.text = FormatCurrency.FormatCurrencyVietNam(itemTrending?.foodPrice)
    holder.numberOrder.text = "Order ${itemTrending?.numberOrder}x"
    holder.foodTrending.text = "#${position + 1}"
    holder.categoryName.text = itemTrending?.categoryName
  }

  override fun getItemCount(): Int {
    return getSizeList(listTrending)
  }

}