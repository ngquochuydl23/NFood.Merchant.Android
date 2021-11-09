package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter

import android.view.ViewGroup
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder.MenuOptionHolder
import com.nsolution.nfoodmerchant.Models.ItemMenuOptionDto
import com.nsolution.nfoodmerchant.R

class MenuOptionAdapter(val listOption : ArrayList<ItemMenuOptionDto>?) : BaseAdapter<MenuOptionHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuOptionHolder {
    val view = getView(parent,viewType, R.layout.item_menu_option)
    return MenuOptionHolder(view)
  }

  override fun onBindViewHolder(holder: MenuOptionHolder, position: Int) {
    val itemOption = listOption?.get(position)

    holder.optionName.text = itemOption?.optionName
    holder.switchOutOfStock.isChecked = itemOption?.isOutOfStock!!
  }

  override fun getItemCount(): Int {
    return getSizeList(listOption)
  }
}