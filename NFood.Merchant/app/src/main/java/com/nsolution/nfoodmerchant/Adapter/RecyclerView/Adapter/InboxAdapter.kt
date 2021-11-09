package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter

import android.view.ViewGroup
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder.InboxHolder
import com.nsolution.nfoodmerchant.Models.ItemInboxDto
import com.nsolution.nfoodmerchant.R

class InboxAdapter(val listNotification: ArrayList<ItemInboxDto>?) :
  BaseAdapter<InboxHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InboxHolder {
    val view = getView(parent, viewType, R.layout.item_inbox)
    return InboxHolder(view)
  }

  override fun onBindViewHolder(holder: InboxHolder, position: Int) {
    val itemNotification = listNotification?.get(position)
    val notificationId = itemNotification?.id

    holder.apply {
      title.text = itemNotification?.title
      subtitle.text = itemNotification?.subtitle
      createdOn.text = itemNotification?.createdOn
    }

    holder.containerLayout.setOnClickListener {
      navigateToNotificationDetail(notificationId)
    }
  }

  override fun getItemCount(): Int {
    if(!listNotification.isNullOrEmpty())
      return listNotification.size
    return 0
  }

  private fun navigateToNotificationDetail(id : Int?){

  }
}