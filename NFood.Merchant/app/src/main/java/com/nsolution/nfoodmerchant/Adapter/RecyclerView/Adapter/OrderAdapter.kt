package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter

import android.content.Intent
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder.OrderHolder
import com.nsolution.nfoodmerchant.Models.ItemOrderDto
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Order.OrderDetail

class OrderAdapter(val listOrder : ArrayList<ItemOrderDto>?) : BaseAdapter<OrderHolder>(){

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderHolder {
    val view = getView(parent,viewType, R.layout.item_order)
    return OrderHolder(view)
  }

  override fun onBindViewHolder(holder: OrderHolder, position: Int) {
    val itemOrder = listOrder?.get(position)

    holder.orderId.text = itemOrder?.orderId
    holder.numberItemForCustomer.text = "${itemOrder?.numberItems} items for ${itemOrder?.customerName}"
    holder.timeToAccepOrder.text = "${itemOrder?.currentTime} mins until driver arrives"
    holder.subTimeToAcceptOrder.text = "${itemOrder?.currentTime} \n mins"

    setImage(holder.driverAvatar,itemOrder?.driverAvatar)



    val currentTime = itemOrder?.currentTime
    val maxTime = itemOrder?.maxTime
    val percentTime = percentTime(currentTime,maxTime)

    println(percentTime)
    holder.progressTimeAcceptOrder.progress = currentTime?.toFloat()!!
    holder.progressTimeAcceptOrder.progressMax = maxTime?.toFloat() !!



    if(percentTime >= 50 && percentTime <= 100){
      holder.progressTimeAcceptOrder.progressBarColor = ContextCompat.getColor(context, R.color.green)
    } else if (percentTime < 50 && percentTime >= 25) {
      holder.progressTimeAcceptOrder.progressBarColor = ContextCompat.getColor(context, R.color.yellow)
    } else {
      holder.progressTimeAcceptOrder.progressBarColor = ContextCompat.getColor(context, R.color.red)
    }

    holder.containerLayout.setOnClickListener {
      val intent = Intent(context,OrderDetail::class.java)
      context.startActivity(intent)
    }
  }

  override fun getItemCount(): Int {
    return getSizeList(listOrder)
  }

  fun percentTime(currentTime : Long?,maxTime : Long?) : Double{
    return (currentTime?.toDouble()!! / maxTime!!) * 100
  }

}