package com.nsolution.nfoodmerchant.Ui.StoreSetting

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter.WorkTimeAdapter
import com.nsolution.nfoodmerchant.Models.ItemWorkTimeDto
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import kotlinx.android.synthetic.main.activity_set_business_hours.*

class SetBusinessHours : BaseActivity() {

  private val EDIT_WORK_TIME = 1

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_set_business_hours)
    initialView()

    getWorkTime()
  }

  private fun initialView() {
    getBackActionBar(header, getString(R.string.business_hours))
    listWorkTime.layoutManager = LinearLayoutManager(this)
  }

  private fun getWorkTime() {
    val monday = ItemWorkTimeDto().apply {
      dayOfWeek = "monday"
      workTime = "06:30 - 22:30"
    }
    val tuesday = ItemWorkTimeDto().apply {
      dayOfWeek = "tuesday"
      workTime = "06:30 - 22:30"
    }
    val wednesday = ItemWorkTimeDto().apply {
      dayOfWeek = "wednesday"
      workTime = "06:30 - 22:30"
    }
    val thursday = ItemWorkTimeDto().apply {
      dayOfWeek = "thursday"
      workTime = "06:30 - 22:30"
    }
    val friday = ItemWorkTimeDto().apply {
      dayOfWeek = "friday"
      workTime = "06:30 - 22:30"
    }
    val staturday = ItemWorkTimeDto().apply {
      dayOfWeek = "staturday"
      workTime = "06:30 - 22:30"
    }
    val sunday = ItemWorkTimeDto().apply {
      dayOfWeek = "sunday"
      workTime = "06:30 - 22:30"
    }

    val workTime = arrayListOf(monday, tuesday, wednesday, thursday, friday, staturday, sunday)

    listWorkTime.adapter = object : WorkTimeAdapter(workTime) {
      override fun editWorkTime() {
        val intent = Intent(this@SetBusinessHours,EditOpeningHours::class.java)
        startActivityForResult(intent,EDIT_WORK_TIME)
      }
    }

  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if(requestCode == EDIT_WORK_TIME && resultCode == Activity.RESULT_OK) {

    }
  }
}
