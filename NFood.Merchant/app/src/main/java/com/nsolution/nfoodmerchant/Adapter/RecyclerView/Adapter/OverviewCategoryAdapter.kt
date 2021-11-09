package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder.OverviewCategoryHolder
import com.nsolution.nfoodmerchant.Models.ItemOverviewCategoryDto
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.MenuManagement.SetupMenu.AddOrEditCategory

open class OverviewCategoryAdapter(
  val listCategory: ArrayList<ItemOverviewCategoryDto>?,
  val isAllowEdit: Boolean) :
  BaseAdapter<OverviewCategoryHolder>() {

  private val CURRENT_CATEGORY = "CURRENT_CATEGORY"

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OverviewCategoryHolder {
    val view = getView(parent, viewType, R.layout.item_overview_category)
    return OverviewCategoryHolder(view)
  }

  @SuppressLint("SetTextI18n")
  override fun onBindViewHolder(holder: OverviewCategoryHolder, position: Int) {
    val itemCategory = listCategory?.get(position)
    val foods = itemCategory?.foods

    holder.listMenuFood.layoutManager = LinearLayoutManager(context)
    holder.categoryName.text = itemCategory?.categoryName
    holder.listMenuFood.adapter = MenuFoodAdapter(foods, isAllowEdit)
    holder.numberItems.text = "${foods?.size} Items"

    if (isAllowEdit) {
      holder.editCategory.visibility = View.VISIBLE
      holder.editCategory.setOnClickListener {
        editCategoryAction(itemCategory)
      }
    }
    holder.containerLayout.setOnClickListener {
      if (holder.expandableLayout.isExpanded)
        holder.expandableLayout.collapse()
      else holder.expandableLayout.expand()
    }
  }

  override fun getItemCount(): Int {
    return getSizeList(listCategory)
  }

  private fun editCategoryAction(currentCategoryDto: ItemOverviewCategoryDto?) {
    val intent = Intent(context, AddOrEditCategory::class.java)
    intent.putExtra(CURRENT_CATEGORY, currentCategoryDto)
    context.startActivity(intent)
  }
}