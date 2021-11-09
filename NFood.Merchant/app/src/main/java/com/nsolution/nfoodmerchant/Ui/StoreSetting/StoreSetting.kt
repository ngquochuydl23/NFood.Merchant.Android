package com.nsolution.nfoodmerchant.Ui.StoreSetting

import android.os.Bundle
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import com.nsolution.nfoodmerchant.Ui.CustomView.BottomSheetView.SetStoreStatusBottomSheet
import kotlinx.android.synthetic.main.activity_store_setting.*

class StoreSetting : BaseActivity() {

  lateinit var bottomSheetFragment: SetStoreStatusBottomSheet

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_store_setting)

    bottomSheetFragment = SetStoreStatusBottomSheet()

    initialView()
  }

  private fun initialView() {
    getBackActionBar(header, getString(R.string.store_setting))
    workTimeLayoutClick.setOnClickListener {
      navigateTo(SetBusinessHours::class.java)
    }

    setStoreStatusLayoutClick.setOnClickListener {
      bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
    }
  }
}
