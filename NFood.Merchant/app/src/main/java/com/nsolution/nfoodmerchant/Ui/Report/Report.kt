package com.nsolution.nfoodmerchant.Ui.Report

import android.os.Bundle
import com.nsolution.nfoodmerchant.Adapter.ViewPager.ReportPagerAdapter
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import kotlinx.android.synthetic.main.activity_report.*

class Report : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_report)
    initialView()
  }

  private fun initialView(){
    getBackActionBar(header,getString(R.string.report))

    tabLayout.setupWithViewPager(viewPager)
    viewPager.adapter = ReportPagerAdapter(supportFragmentManager)
  }
}
