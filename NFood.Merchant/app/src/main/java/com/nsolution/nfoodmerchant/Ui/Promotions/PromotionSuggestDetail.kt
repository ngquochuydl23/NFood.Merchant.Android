package com.nsolution.nfoodmerchant.Ui.Promotions

import android.os.Bundle
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity

class PromotionSuggestDetail : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_promotion_suggest_detail)
    initialView()
  }

  private fun initialView(){
    collapsingToolbarLayout("Get 30% off for the New Year !")
  }
}
