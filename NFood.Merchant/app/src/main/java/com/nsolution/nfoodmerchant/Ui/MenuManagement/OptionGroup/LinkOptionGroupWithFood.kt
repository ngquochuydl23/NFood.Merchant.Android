package com.nsolution.nfoodmerchant.Ui.MenuManagement.OptionGroup

import android.os.Bundle
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import kotlinx.android.synthetic.main.activity_link_option_group_with_food.*

class LinkOptionGroupWithFood : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_link_option_group_with_food)

    initialView()
  }

  private fun initialView(){
    getBackActionBar(header,getString(R.string.link_option_group))
  }
}
