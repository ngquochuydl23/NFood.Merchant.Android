package com.nsolution.nfoodmerchant.Ui.Payment

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter.PaymentAdapter
import com.nsolution.nfoodmerchant.Models.ItemPaymentDto
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import kotlinx.android.synthetic.main.activity_payment.*

class Payment : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_payment)

    initialView()
    getListPayment()
  }

  private fun initialView() {
    getBackActionBar(header, getString(R.string.payment))
    listPayment.layoutManager = LinearLayoutManager(this)
  }

  private fun getListPayment() {
    val itemPayment = ItemPaymentDto().apply {
      paymentTitle = "NFood Payment Transfer from ng****** to +621312321"
      paymentDate = "Today 13:27"
      paymentCost = 60000.0
    }
    listPayment.adapter =
      PaymentAdapter(arrayListOf(itemPayment, itemPayment, itemPayment, itemPayment))
  }
}
