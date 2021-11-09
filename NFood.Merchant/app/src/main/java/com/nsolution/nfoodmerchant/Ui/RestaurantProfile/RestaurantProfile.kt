package com.nsolution.nfoodmerchant.Ui.RestaurantProfile


import android.os.Bundle
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import kotlinx.android.synthetic.main.activity_restaurant_profile.*

class RestaurantProfile : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_restaurant_profile)
    initialView()
  }

  private fun initialView(){
    restaurantAddressDetail.setOnClickListener {
      navigateTo(RestaurantAddress::class.java)
    }


    bankAccountButton.setOnClickListener {
      navigateTo(RestaurantBankAccount::class.java)
    }

    updateRestaurantInformationButton.setOnClickListener {

    }
  }
}
