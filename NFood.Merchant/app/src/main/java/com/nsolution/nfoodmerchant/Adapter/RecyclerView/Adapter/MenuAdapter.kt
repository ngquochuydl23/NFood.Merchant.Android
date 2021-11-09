package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.ViewGroup
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder.MenuHolder
import com.nsolution.nfoodmerchant.Models.ItemMenuDto
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.MenuManagement.SetupMenu.AddOrEditMenu
import com.nsolution.nfoodmerchant.Ui.MenuManagement.SetupMenu.AddOrEditMenu.Companion.CURRENT_MENU

class MenuAdapter(val listMenu: ArrayList<ItemMenuDto>?) : BaseAdapter<MenuHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuHolder {
    val view = getView(parent, viewType, R.layout.item_menu)
    return MenuHolder(view)
  }

  @SuppressLint("SetTextI18n")
  override fun onBindViewHolder(holder: MenuHolder, position: Int) {
    val itemMenu = listMenu?.get(position)

    holder.menuTitle.text = itemMenu?.menuTitle
    holder.menuAvailability.text = itemMenu?.menuAvailability
    holder.numberCategories.text = "Categories : ${itemMenu?.numberCategories}"
    holder.numberItems.text = "Items : ${itemMenu?.numberItems}"

    holder.containerLayout.setOnClickListener {
      val intent = Intent(context, AddOrEditMenu::class.java)
      intent.putExtra(CURRENT_MENU, itemMenu)
      context.startActivity(intent)
    }
  }

  override fun getItemCount(): Int {
    return getSizeList(listMenu)
  }
}