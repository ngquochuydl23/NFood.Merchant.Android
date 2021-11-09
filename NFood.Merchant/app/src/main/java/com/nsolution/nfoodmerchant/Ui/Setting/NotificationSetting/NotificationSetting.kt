package com.nsolution.nfoodmerchant.Ui.Setting.NotificationSetting

import android.os.Bundle
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import kotlinx.android.synthetic.main.activity_notification_setting.*

class NotificationSetting : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_notification_setting)
    initialView()
  }

  private fun initialView() {
    getBackActionBar(header, getString(R.string.notification_setting))

    setUpSoundLayoutClick.setOnClickListener {
      navigateTo(SetupSoundAlertOrder::class.java)
    }
  }
}
