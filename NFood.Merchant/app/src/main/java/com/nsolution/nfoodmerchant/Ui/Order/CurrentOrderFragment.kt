package com.nsolution.nfoodmerchant.Ui.Order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter.OrderAdapter
import com.nsolution.nfoodmerchant.Models.ItemOrderDto
import com.nsolution.nfoodmerchant.R
import kotlinx.android.synthetic.main.fragment_current_order.*

class CurrentOrderFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_current_order, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initialView()
    getListCurrentOrder()
  }

  private fun initialView() {
    listCurrentOrder.layoutManager = LinearLayoutManager(context)

  }

  private fun getListCurrentOrder() {
    val itemCurrentOrderGreen = ItemOrderDto().apply {
      orderId = "NF-23032020-2019"
      numberItems = 6
      customerName = "Meo Ami"
      maxTime = 25
      currentTime = 18
      driverAvatar = "https://deadline.com/wp-content/uploads/2019/09/emily-in-paris-4.jpg"
    }
    val itemCurrentOrderYellow = ItemOrderDto().apply {
      orderId = "NF-23032020-2019"
      numberItems = 6
      customerName = "Meo Ami"
      maxTime = 25
      currentTime = 10
      driverAvatar = "https://deadline.com/wp-content/uploads/2019/09/emily-in-paris-4.jpg"
    }
    val itemCurrentOrderRed = ItemOrderDto().apply {
      orderId = "NF-23032020-2019"
      numberItems = 6
      customerName = "Meo Ami"
      maxTime = 25
      currentTime = 5
      driverAvatar = "https://deadline.com/wp-content/uploads/2019/09/emily-in-paris-4.jpg"
      }

    listCurrentOrder.adapter = OrderAdapter                                                       (arrayListOf(itemCurrentOrderGreen,itemCurrentOrderYellow,itemCurrentOrderRed))

  }
}
