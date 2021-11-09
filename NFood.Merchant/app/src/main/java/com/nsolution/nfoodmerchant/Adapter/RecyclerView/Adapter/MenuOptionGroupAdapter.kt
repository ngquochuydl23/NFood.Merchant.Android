package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder.MenuOptionGroupHolder
import com.nsolution.nfoodmerchant.Models.ItemMenuOptionGroupDto
import com.nsolution.nfoodmerchant.R

class MenuOptionGroupAdapter(val listOptionGroup: ArrayList<ItemMenuOptionGroupDto>?) :
  BaseAdapter<MenuOptionGroupHolder>() {


  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuOptionGroupHolder {
    val view = getView(parent,viewType, R.layout.item_menu_option_group)
    return MenuOptionGroupHolder(view)
  }

  override fun onBindViewHolder(holder: MenuOptionGroupHolder, position: Int) {
    val itemOptionGroup = listOptionGroup?.get(position)

    holder.optionGroupName.text = itemOptionGroup?.optionGroupName

    holder.listOption.layoutManager = LinearLayoutManager(context)
    holder.listOption.adapter = MenuOptionAdapter(itemOptionGroup?.listOption)

    holder.containerLayout.setOnClickListener {
      if (holder.expandableLayout.isExpanded)
        holder.expandableLayout.collapse()
      else holder.expandableLayout.expand()
    }
  }

  override fun getItemCount(): Int {
    return getSizeList(listOptionGroup)
  }
}