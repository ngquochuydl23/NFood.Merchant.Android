package com.nsolution.nfoodmerchant.Ui.MenuManagement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter.OverviewCategoryAdapter
import com.nsolution.nfoodmerchant.Models.ItemOverviewCategoryDto
import com.nsolution.nfoodmerchant.Network.IHttpClient
import com.nsolution.nfoodmerchant.Network.IMenu
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseFragment
import kotlinx.android.synthetic.main.fragment_all_food.*

class AllFoodFragment : BaseFragment() {

  lateinit var service: IMenu

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_all_food, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    service = IHttpClient.retrofit.create(IMenu::class.java)

    initialView()
    getCategories()
  }

  private fun initialView() {
    progressBar.visibility = View.VISIBLE
    categories.layoutManager = LinearLayoutManager(context)
  }

  private fun getCategories() {



    val itemCategory = ItemOverviewCategoryDto().apply {
      categoryId = 1
      categoryName = "Combo Meals"
      foods = arrayListOf()
    }

    categories.adapter =
      OverviewCategoryAdapter(arrayListOf(itemCategory, itemCategory, itemCategory,itemCategory), false)
  }
}
