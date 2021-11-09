package com.nsolution.nfoodmerchant.Ui.StoreSetting

import android.os.Bundle
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import kotlinx.android.synthetic.main.activity_edit_opening_hours.*

class EditOpeningHours : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_edit_opening_hours)
    initialView()
  }

  private fun initialView(){
    getBackActionBar(header,getString(R.string.edit_opening_hours))
  }
}
