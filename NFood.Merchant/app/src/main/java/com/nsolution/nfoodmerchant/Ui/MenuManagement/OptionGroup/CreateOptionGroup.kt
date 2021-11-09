package com.nsolution.nfoodmerchant.Ui.MenuManagement.OptionGroup

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter.CreateOptionAdapter
import com.nsolution.nfoodmerchant.Models.ItemOptionDto
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import kotlinx.android.synthetic.main.activity_create_option_group.*

class CreateOptionGroup : BaseActivity() {

  private val LAUNCH_ADD_NEW_OPTION_ACTIVITY = 1
  private val NEW_OPTION = "NEW_OPTION"
  private val listOption = arrayListOf<ItemOptionDto>()
  private lateinit var optionAdapter: CreateOptionAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_create_option_group)

    optionAdapter = CreateOptionAdapter(listOption)
    initialView()
  }

  private fun initialView() {
    listOptionRecyclerView.layoutManager = LinearLayoutManager(this)
    listOptionRecyclerView.adapter = optionAdapter
    getBackActionBar(header, getString(R.string.create_option_group))

    addOption.setOnClickListener {
      navigateToAddNewOption()
    }

    reviewOptionGroupButton.setOnClickListener {

    }
  }

  private fun navigateToAddNewOption() {
    val intent = Intent(this, AddNewItemOption::class.java)
    startActivityForResult(intent, LAUNCH_ADD_NEW_OPTION_ACTIVITY)
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (requestCode == LAUNCH_ADD_NEW_OPTION_ACTIVITY && resultCode == Activity.RESULT_OK) {
      val newOption = data?.getSerializableExtra(NEW_OPTION) as ItemOptionDto
      addNewOptionToList(newOption)
    }
  }

  private fun addNewOptionToList(newOption: ItemOptionDto) {
    optionAdapter.addNewItem(listOption, newOption)
  }
}
