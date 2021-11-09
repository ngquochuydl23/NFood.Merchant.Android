package com.nsolution.nfoodmerchant.Ui.Inbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter.InboxAdapter
import com.nsolution.nfoodmerchant.Models.ItemInboxDto
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import kotlinx.android.synthetic.main.activity_inbox.*

class Inbox : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_inbox)

    getBackActionBar(header,getString(R.string.inbox))

    listInbox.layoutManager = LinearLayoutManager(this)

    getListInbox()
  }

  private fun getListInbox(){
    val notification1 = ItemInboxDto().apply {
      title = "Free NFood Merchant for new customers"
      subtitle = "Tap and get the big deals for your first booking"
      createdOn = "23/03/2020"
    }

    listInbox.adapter = InboxAdapter(
      arrayListOf(notification1, notification1, notification1, notification1)
    )
  }
}
