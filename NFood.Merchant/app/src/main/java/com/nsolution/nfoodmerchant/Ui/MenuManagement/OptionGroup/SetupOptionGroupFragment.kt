package com.nsolution.nfoodmerchant.Ui.MenuManagement.OptionGroup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter.EditOptionGroupAdapter
import com.nsolution.nfoodmerchant.Models.ItemEditOptionGroupDto
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseFragment
import kotlinx.android.synthetic.main.fragment_setup_option_group.*


class SetupOptionGroupFragment : BaseFragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_setup_option_group, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initialView()

    getOptionGroup()
  }

  private fun initialView(){

    listOptionGroup.layoutManager = LinearLayoutManager(context)
    createOptionGroupButton.setOnClickListener {
      navigateTo(CreateOptionGroup::class.java)
    }
  }

  private fun getOptionGroup(){
    val itemOptionGroup = ItemEditOptionGroupDto().apply {
      id = 1
      numberItemLinked = 3
      optionGroupName = "Lượng Đường"
    }
    listOptionGroup.adapter = EditOptionGroupAdapter(arrayListOf(itemOptionGroup,itemOptionGroup,itemOptionGroup))
  }
}
