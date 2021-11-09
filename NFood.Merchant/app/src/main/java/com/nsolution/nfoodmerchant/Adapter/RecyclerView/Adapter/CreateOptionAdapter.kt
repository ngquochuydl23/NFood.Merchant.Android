package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter

import android.view.ViewGroup
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder.CreateOptionHolder
import com.nsolution.nfoodmerchant.Models.ItemOptionDto
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Currency.FormatCurrency

class CreateOptionAdapter(val listOption : ArrayList<ItemOptionDto>?) : BaseAdapter<CreateOptionHolder>(){

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreateOptionHolder {
    val view = getView(parent,viewType, R.layout.item_create_option)
    return CreateOptionHolder(view)
  }

  override fun onBindViewHolder(holder: CreateOptionHolder, position: Int) {
    val itemOption = listOption?.get(position)

    holder.optionName.text = itemOption?.optionName
    holder.optionPrice.text = FormatCurrency.FormatCurrencyVietNam(itemOption?.optionPrice)

    holder.containerLayout.setOnClickListener {

    }
  }

  override fun getItemCount(): Int {
    return getSizeList(listOption)
  }
}