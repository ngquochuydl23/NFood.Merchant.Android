package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder.CategoryHolder
import com.nsolution.nfoodmerchant.Models.ItemCategoryDto
import com.nsolution.nfoodmerchant.R

class CategoryAdapter(val categories : ArrayList<ItemCategoryDto>?) : BaseAdapter<CategoryHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
    val view = getView(parent,viewType, R.layout.item_category)
    return CategoryHolder(view)
  }

  @SuppressLint("SetTextI18n")
  override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
    val category = categories?.get(position)

    holder.categoryName.text = category?.categoryName
    holder.menuAndNumberItems.text = "${category?.menu} \u2022 ${category?.numberItems} Items"
    holder.containerLayout.setOnClickListener {

    }
  }

  override fun getItemCount(): Int {
    return getSizeList(categories)
  }
}