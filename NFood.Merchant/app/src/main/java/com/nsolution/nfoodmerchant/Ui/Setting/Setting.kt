package com.nsolution.nfoodmerchant.Ui.Setting

import android.os.Bundle
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import com.nsolution.nfoodmerchant.Ui.Setting.LanguageSetting.LanguageSetting
import com.nsolution.nfoodmerchant.Ui.Setting.NotificationSetting.NotificationSetting
import kotlinx.android.synthetic.main.activity_setting.*

class Setting : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_setting)

    initialView()
  }

  private fun initialView() {
    getBackActionBar(header, getString(R.string.setting))

    setUpNotificationLayoutClick.setOnClickListener {
      navigateTo(NotificationSetting::class.java)
    }

    setUpLanguageLayoutClick.setOnClickListener {
      navigateTo(LanguageSetting::class.java)
    }
  }
}
