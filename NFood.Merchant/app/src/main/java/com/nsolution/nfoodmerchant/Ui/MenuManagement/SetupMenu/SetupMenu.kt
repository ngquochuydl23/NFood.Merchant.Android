package com.nsolution.nfoodmerchant.Ui.MenuManagement.SetupMenu

import android.os.Bundle
import com.nsolution.nfoodmerchant.Adapter.ViewPager.SetupMenuPagerAdapter
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import kotlinx.android.synthetic.main.activity_setup_menu.*

class SetupMenu : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_setup_menu)
    initialView()
  }

  private fun initialView(){
    getBackActionBar(header,getString(R.string.setup_menu))
    tabLayout.setupWithViewPager(viewPager)
    viewPager.adapter = SetupMenuPagerAdapter(supportFragmentManager)
  }
}
