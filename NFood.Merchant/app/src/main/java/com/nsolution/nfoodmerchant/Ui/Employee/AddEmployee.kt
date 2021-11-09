package com.nsolution.nfoodmerchant.Ui.Employee

import android.os.Bundle
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import kotlinx.android.synthetic.main.activity_add_employee.*

class AddEmployee : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_add_employee)

    initialView()
  }

  private fun initialView() {
    getBackActionBar(header, getString(R.string.add_an_employee))
  }
}
