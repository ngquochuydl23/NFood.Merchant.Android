package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder.MostFavouriteFoodHolder
import com.nsolution.nfoodmerchant.Models.ItemMostFavouriteFoodDto
import com.nsolution.nfoodmerchant.R

class MostFavouriteFoodAdapter(val listFavourite: ArrayList<ItemMostFavouriteFoodDto>?) :
  BaseAdapter<MostFavouriteFoodHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostFavouriteFoodHolder {
    val view = getView(parent, viewType, R.layout.item_most_favourite)
    return MostFavouriteFoodHolder(view)
  }

  @SuppressLint("SetTextI18n")
  override fun onBindViewHolder(holder: MostFavouriteFoodHolder, position: Int) {
    val itemFavourite = listFavourite?.get(position)

    setImage(holder.foodImage,itemFavourite?.foodImage)
    holder.foodName.text = itemFavourite?.foodName
    holder.foodRated.rating = itemFavourite?.foodRated?.toFloat() !!
    holder.numberOrder.text = "Order ${itemFavourite?.numberOrder}x"
    holder.categoryName.text = itemFavourite?.categoryName
  }

  override fun getItemCount(): Int {
    return getSizeList(listFavourite)
  }

}