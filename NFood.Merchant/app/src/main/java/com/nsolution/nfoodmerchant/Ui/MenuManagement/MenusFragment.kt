package com.nsolution.nfoodmerchant.Ui.MenuManagement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter.MenuAdapter
import com.nsolution.nfoodmerchant.Models.ItemMenuDto
import com.nsolution.nfoodmerchant.R
import kotlinx.android.synthetic.main.fragment_menus.*


class MenusFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_menus, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initialView()

    getListMenu()
  }

  private fun initialView() {
    listMenu.layoutManager = LinearLayoutManager(context)
  }

  private fun getListMenu() {
    val itemMenu = ItemMenuDto().apply {
      id = 1
      menuTitle = "Breakfast"
      menuAvailability = "Monday - Friday, 07:00AM  10:00AM"
      numberCategories = 5
      numberItems = 25
    }

    val itemMenu1 = ItemMenuDto().apply {
      id = 1
      menuTitle = "Lunch"
      menuAvailability = "Monday - Friday, 11:00AM  02:00PM"
      numberCategories = 5
      numberItems = 25
    }

    listMenu.adapter = MenuAdapter(arrayListOf(itemMenu, itemMenu1, itemMenu))
  }
}
