package com.nsolution.nfoodmerchant.Ui.CustomView.BottomSheetView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.MenuManagement.SetupMenu.AddOrEditCategory
import com.nsolution.nfoodmerchant.Ui.MenuManagement.SetupMenu.AddOrEditFood
import kotlinx.android.synthetic.main.layout_bottomsheet_add_food_or_category.*

class AddFoodOrCategotyBottomSheet : BaseBottomSheet() {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return LayoutInflater.from(context)
      .inflate(R.layout.layout_bottomsheet_add_food_or_category, container)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initialView()
  }

  private fun initialView() {
    addNewItem.setOnClickListener {
      navigateTo(AddOrEditFood::class.java)
      this.dismiss()
    }

    addNewCategory.setOnClickListener {
      navigateTo(AddOrEditCategory::class.java)
      this.dismiss()
    }
  }
}