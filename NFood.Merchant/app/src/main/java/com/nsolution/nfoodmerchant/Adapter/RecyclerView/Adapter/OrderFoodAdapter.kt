package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter

import android.view.View
import android.view.ViewGroup
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder.OrderFoodHolder
import com.nsolution.nfoodmerchant.Models.ItemOrderFoodDto
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Currency.FormatCurrency

class OrderFoodAdapter(val listOrderSummary: ArrayList<ItemOrderFoodDto>?) :
  BaseAdapter<OrderFoodHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderFoodHolder {
    val view = getView(parent, viewType, R.layout.item_order_food)
    return OrderFoodHolder(view)
  }

  override fun onBindViewHolder(holder: OrderFoodHolder, position: Int) {
    val itemOrderSummary = listOrderSummary?.get(position)

    holder.foodName.text = itemOrderSummary?.foodName
    holder.foodNote.text = itemOrderSummary?.foodNote
    holder.foodCost.text = FormatCurrency.FormatCurrencyVietNam(itemOrderSummary?.foodPrice)

    if(itemOrderSummary?.foodNote.isNullOrEmpty())
      holder.foodNote.visibility = View.GONE

    holder.quanlity.text = "x" + itemOrderSummary?.quanlity
  }

  override fun getItemCount(): Int {
    return getSizeList(listOrderSummary)
  }
}