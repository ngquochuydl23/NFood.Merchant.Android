package com.nsolution.nfoodmerchant.Ui.CustomView.BottomSheetView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nsolution.nfoodmerchant.Models.ItemMenuFoodDto
import com.nsolution.nfoodmerchant.R
import kotlinx.android.synthetic.main.layout_bottomsheet_sold_out.*

open class SoldOutFoodBottomSheet : BaseBottomSheet() {

  private var foodName: String? = null
  private var foodId: Int? = null
  private var isOutOfStock: Boolean = true
  private val OUT_OF_STOCK_TODAY = "Out of stock today"
  private val OUT_OF_STOCK_INDEFINITELY = "Out of stock indefinitely"

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return LayoutInflater.from(context).inflate(R.layout.layout_bottomsheet_sold_out, container)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initialView()
  }

  private fun initialView() {
    closeButton.setOnClickListener {
      this.dismiss()
    }

    soldOutForToday.setOnClickListener {
      soldOutForToDayAction()
      this.dismiss()
    }

    soldOutForIndefinitely.setOnClickListener {
      soldOutForIndefinitelyAction()
      this.dismiss()
    }
  }

  fun setFoodName(itemMenuFood: ItemMenuFoodDto?) {
    this.foodName = itemMenuFood?.foodName
    this.foodId = itemMenuFood?.foodId
  }

  open fun soldOutForToDayAction() {

  }

  open fun soldOutForIndefinitelyAction() {

  }

  interface BottomSheetListener{
    fun onSoldOutForToday()
    fun onSoldOutForIndefinitely()
  }
}