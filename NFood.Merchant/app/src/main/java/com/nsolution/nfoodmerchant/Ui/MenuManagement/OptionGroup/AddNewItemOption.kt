package com.nsolution.nfoodmerchant.Ui.MenuManagement.OptionGroup

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.nsolution.nfoodmerchant.Models.ItemOptionDto
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import kotlinx.android.synthetic.main.activity_add_new_item_option.*

class AddNewItemOption : BaseActivity() {

  private val NEW_OPTION = "NEW_OPTION"
  private var defaultPrice : Double? = 0.0

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_add_new_item_option)
    initialView()
  }

  private fun initialView(){
    getBackActionBar(header,getString(R.string.add_new_option))
    addNewOptionButton.setOnClickListener {
      addNewOption()
    }
  }

  private fun addNewOption(){
    val newItemOption = ItemOptionDto()
    newItemOption.optionName = enterOptionName.text.toString()

    if(enterFoodPrice.text.isNotEmpty())
      defaultPrice = enterFoodPrice.text.toString().toDoubleOrNull()

    newItemOption.optionPrice = defaultPrice
    returnIntent(newItemOption)
    finish()
  }

  private fun returnIntent(newItemOptionDto: ItemOptionDto){
    val returnIntent = Intent()
    returnIntent.putExtra(NEW_OPTION,newItemOptionDto)
    setResult(Activity.RESULT_OK,returnIntent)
  }
}
