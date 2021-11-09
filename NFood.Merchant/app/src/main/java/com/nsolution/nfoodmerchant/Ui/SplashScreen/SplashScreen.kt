package com.nsolution.nfoodmerchant.Ui.SplashScreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.SharedReferences.SaveTokenSharedPreferences
import com.nsolution.nfoodmerchant.Ui.AuthScreen.AuthenticationScreen
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import com.nsolution.nfoodmerchant.Ui.Order.Order

class SplashScreen : BaseActivity() {

  private val DELAY_MILLIS : Long = 2500

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_splash_screen)
    initialView()
  }

  private fun initialView(){
    setupWindow()
    val handler = Handler()
    handler.postDelayed(delayInMinutes, DELAY_MILLIS)
  }

  private fun setupWindow(){
    getWindow().setFlags(
      WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
      WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
  }

  private val delayInMinutes = Runnable{
    if(getTokenFromDevice().isNullOrEmpty()){
      navigateToAuthenticateScreen()
    } else navigateToOrderScreen()
  }

  private fun navigateToAuthenticateScreen(){
    navigateTo(AuthenticationScreen::class.java)
    finish()
  }

  private fun navigateToOrderScreen(){
    navigateTo(Order::class.java)
    finish()
  }

  private fun getTokenFromDevice() : String?{
    return SaveTokenSharedPreferences(this).getData()
  }
}
