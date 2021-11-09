package com.nsolution.nfoodmerchant.Ui.Promotions.CreatePromotion

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter.SuggestPromotionAdapter
import com.nsolution.nfoodmerchant.Models.ItemSuggestPromotionDto
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import kotlinx.android.synthetic.main.activity_create_promotion.*

class CreatePromotion : BaseActivity() {

  lateinit var createMenuDiscountLayout: View
  lateinit var createTotalOrderDiscount: View
  lateinit var createDiscountDelivery: View

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_create_promotion)

    createMenuDiscountLayout = findViewById(R.id.createMenuDiscountLayout)
    createTotalOrderDiscount = findViewById(R.id.createTotalOrderDiscount)
    createDiscountDelivery = findViewById(R.id.createDiscountDelivery)

    initialView()

    getSuggestPromotion()
  }

  private fun initialView() {
    getBackActionBar(header, getString(R.string.create_promotion))
    listSuggestPromotion.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

    createMenuDiscountLayout.setOnClickListener {
      navigateTo(SetupPromotion::class.java)
    }

    createTotalOrderDiscount.setOnClickListener {
      navigateTo(SetupPromotion::class.java)
    }

    createDiscountDelivery.setOnClickListener {
      navigateTo(SetupPromotion::class.java)
    }
  }

  private fun getSuggestPromotion() {
    val itemSuggest = ItemSuggestPromotionDto().apply {
      id = 1
      title = "Gói COMBO 1"
      subtitle = "Ưu đãi giảm ngay 40$ tối đa 40k cho dịch vụ NFood"
      minOrderPrice = 40000.0
      expiration = "Hết hạn : Th9 27, 2020"
    }
    listSuggestPromotion.adapter =
      SuggestPromotionAdapter(arrayListOf(itemSuggest, itemSuggest, itemSuggest, itemSuggest))
  }
}
