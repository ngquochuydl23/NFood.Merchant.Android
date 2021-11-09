package com.nsolution.nfoodmerchant.Ui.Promotions

import android.os.Bundle
import com.nsolution.nfoodmerchant.Adapter.ViewPager.PromotionPagerAdapter
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import com.nsolution.nfoodmerchant.Ui.Promotions.CreatePromotion.CreatePromotion
import kotlinx.android.synthetic.main.activity_promotions.*

class Promotions : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_promotions)

    initialView()
  }

  private fun initialView(){
    getBackActionBar(header,getString(R.string.promotion))

    tabLayout.setupWithViewPager(viewPager)
    viewPager.adapter = PromotionPagerAdapter(supportFragmentManager)

    createPromotionButton.setOnClickListener {
      navigateTo(CreatePromotion::class.java)
    }
  }
}
