package com.nsolution.nfoodmerchant.Ui.MenuManagement.SetupMenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter.CategoryAdapter
import com.nsolution.nfoodmerchant.Models.ItemCategoryDto
import com.nsolution.nfoodmerchant.R
import kotlinx.android.synthetic.main.fragment_menu_categories.*

class MenuCategoriesFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_menu_categories, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initialView()

    val category = ItemCategoryDto().apply {
      categoryName = "Combo Meals"
      numberItems = 9
      menu = "Breakfast"
    }

    categories.adapter = CategoryAdapter(arrayListOf(category,category,category,category))
  }

  private fun initialView(){
    categories.layoutManager = LinearLayoutManager(context)
  }
}
