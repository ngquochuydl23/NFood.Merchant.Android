package com.nsolution.nfoodmerchant.Ui.MenuManagement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter.MenuOptionGroupAdapter
import com.nsolution.nfoodmerchant.Models.ItemMenuOptionDto
import com.nsolution.nfoodmerchant.Models.ItemMenuOptionGroupDto

import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseFragment
import kotlinx.android.synthetic.main.fragment_option_group.*


class OptionGroupFragment : BaseFragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_option_group, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initialView()
    getListOptionGroup()
  }

  private fun initialView(){
    listOptionGroup.layoutManager = LinearLayoutManager(context)
  }

  private fun getListOptionGroup() {
    val itemOption = ItemMenuOptionDto().apply {
      optionId = 1
      optionGroupId = 1
      optionName = "50% Đá"
      isOutOfStock = false
    }

    val itemOptionGroup = ItemMenuOptionGroupDto().apply {
      id = 1
      optionGroupName = "Lượng đường"
      listOption = arrayListOf(itemOption,itemOption,itemOption)
    }

    listOptionGroup.adapter = MenuOptionGroupAdapter(arrayListOf(itemOptionGroup,itemOptionGroup,itemOptionGroup))
  }
}
