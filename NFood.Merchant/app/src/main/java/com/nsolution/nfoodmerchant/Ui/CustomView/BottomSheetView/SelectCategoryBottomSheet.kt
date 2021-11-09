package com.nsolution.nfoodmerchant.Ui.CustomView.BottomSheetView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter.SelectCategoryAdapter
import com.nsolution.nfoodmerchant.Models.ItemSelectCategoryDto
import com.nsolution.nfoodmerchant.R
import kotlinx.android.synthetic.main.layout_bottomsheet_select_category.*


class SelectCategoryBottomSheet : BaseBottomSheet() {

  private var listCategory: ArrayList<ItemSelectCategoryDto>? = arrayListOf()
  private var lastSelectCategory: ItemSelectCategoryDto? = null

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return LayoutInflater.from(context)
      .inflate(R.layout.layout_bottomsheet_select_category, container)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initialView()
  }

  private fun initialView() {
    val bottomSheetListener = context as BottomSheetListener
    disableSelectButton()

    selectCategoryRecyclerView.layoutManager = LinearLayoutManager(context)
    selectCategoryRecyclerView.adapter = object : SelectCategoryAdapter(listCategory) {
      override fun onSelectItemCategory(itemSelectedCategory: ItemSelectCategoryDto?) {
        super.onSelectItemCategory(itemSelectedCategory)
        lastSelectCategory = itemSelectedCategory
        enableSelectButton()
      }
    }

    selectCategoryButton.setOnClickListener {
      if (lastSelectCategory != null) {
        bottomSheetListener.onSelectItemCategory(lastSelectCategory)
        this.dismiss()
      }
    }
  }

  fun setListCategory(listCategory: ArrayList<ItemSelectCategoryDto>?) {
    this.listCategory = listCategory
  }

  private fun enableSelectButton() {
    selectCategoryButton.isEnabled = true
    selectCategoryButton.backgroundTintList = context?.resources?.getColorStateList(R.color.green)
  }

  private fun disableSelectButton() {
    selectCategoryButton.isEnabled = false
    selectCategoryButton.backgroundTintList =
      context?.resources?.getColorStateList(R.color.light_gray)
  }

  interface BottomSheetListener {
    fun onSelectItemCategory(selectedCategory: ItemSelectCategoryDto?)
  }
}