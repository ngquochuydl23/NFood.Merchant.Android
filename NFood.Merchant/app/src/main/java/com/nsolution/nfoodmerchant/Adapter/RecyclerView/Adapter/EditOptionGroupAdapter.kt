package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.ViewGroup
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder.EditOptionGroupHolder
import com.nsolution.nfoodmerchant.Models.ItemEditOptionGroupDto
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.MenuManagement.OptionGroup.CreateOptionGroup
import com.nsolution.nfoodmerchant.Ui.MenuManagement.OptionGroup.LinkOptionGroupWithFood

class EditOptionGroupAdapter(val listOptionGroup: ArrayList<ItemEditOptionGroupDto>?) :
  BaseAdapter<EditOptionGroupHolder>() {


  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditOptionGroupHolder {
    val view = getView(parent, viewType, R.layout.item_edit_option_group)
    return EditOptionGroupHolder(view)
  }

  @SuppressLint("SetTextI18n")
  override fun onBindViewHolder(holder: EditOptionGroupHolder, position: Int) {
    val itemOptionGroup = listOptionGroup?.get(position)

    holder.optionGroupName.text = itemOptionGroup?.optionGroupName
    holder.numberItemLinked.text = "${itemOptionGroup?.numberItemLinked} Item Linked "
    holder.containerLayout.setOnClickListener {
      val intent = Intent(context, CreateOptionGroup::class.java)
      context.startActivity(intent)
    }

    holder.numberItemLinked.setOnClickListener {
      val intent = Intent(context, LinkOptionGroupWithFood::class.java)
      context.startActivity(intent)
    }
  }

  override fun getItemCount(): Int {
    return getSizeList(listOptionGroup)
  }

}