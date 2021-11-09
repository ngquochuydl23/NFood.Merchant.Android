package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter

import android.view.ViewGroup
import android.widget.RadioButton
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder.SelectCategoryHolder
import com.nsolution.nfoodmerchant.Models.ItemSelectCategoryDto
import com.nsolution.nfoodmerchant.R

open class SelectCategoryAdapter(val listCategory: ArrayList<ItemSelectCategoryDto>?) :
  BaseAdapter<SelectCategoryHolder>() {

  var positionItemIsSelected = -1
  var lastCheckedRadioButton : RadioButton? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectCategoryHolder {
    val view = getView(parent, viewType, R.layout.item_select_category)
    return SelectCategoryHolder(view)
  }

  override fun onBindViewHolder(holder: SelectCategoryHolder, position: Int) {
    val itemCategory = listCategory?.get(position)

    holder.categoryName.text = itemCategory?.categoryName
    holder.selectButton.setOnClickListener {
      holder.isSelected.isChecked = true

      if(lastCheckedRadioButton != null){
        lastCheckedRadioButton?.isChecked = false
      }
      lastCheckedRadioButton = holder.isSelected
      positionItemIsSelected = position
      onSelectItemCategory(itemCategory)
    }
  }

  override fun getItemCount(): Int {
    return getSizeList(listCategory)
  }

  open fun onSelectItemCategory(itemSelectedCategory: ItemSelectCategoryDto?){

  }
}