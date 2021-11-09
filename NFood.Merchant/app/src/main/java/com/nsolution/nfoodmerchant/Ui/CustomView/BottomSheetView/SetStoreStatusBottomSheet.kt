package com.nsolution.nfoodmerchant.Ui.CustomView.BottomSheetView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nsolution.nfoodmerchant.R
import kotlinx.android.synthetic.main.layout_bottomsheet_set_store_status.*

class SetStoreStatusBottomSheet : BaseBottomSheet() {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return LayoutInflater.from(context)
      .inflate(R.layout.layout_bottomsheet_set_store_status, container)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initialView()
  }

  private fun initialView(){
    confirmButton.setOnClickListener {
      dismiss()
    }
  }
}