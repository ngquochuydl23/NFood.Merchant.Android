package com.nsolution.nfoodmerchant.Ui.MenuManagement

import android.os.Bundle
import com.nsolution.nfoodmerchant.Adapter.ViewPager.MenuPagerAdapter
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import com.nsolution.nfoodmerchant.Ui.MenuManagement.SetupMenu.SetupMenu
import kotlinx.android.synthetic.main.activity_menu_management.*

class MenuManagement : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_menu_management)

    initialView()
  }

  private fun initialView(){
    getBackActionBar(header,getString(R.string.menu_management))

    tabLayout.setupWithViewPager(viewPager)
    viewPager.adapter = MenuPagerAdapter(supportFragmentManager)
    viewPager.offscreenPageLimit = 4

    updateMenuButton.setOnClickListener {
      navigateTo(SetupMenu::class.java)
    }
  }
}
