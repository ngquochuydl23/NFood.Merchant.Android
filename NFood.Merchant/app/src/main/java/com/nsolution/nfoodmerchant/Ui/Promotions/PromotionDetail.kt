package com.nsolution.nfoodmerchant.Ui.Promotions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import kotlinx.android.synthetic.main.activity_promotion_detail.*

class PromotionDetail : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_promotion_detail)
    initialView()
  }

  private fun initialView(){
    getBackActionBar(header,getString(R.string.promotion_details))
  }
}
