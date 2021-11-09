package com.nsolution.nfoodmerchant.Ui.MenuManagement.SetupMenu

import android.os.Bundle
import com.nsolution.nfoodmerchant.Models.ItemMenuDto
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import kotlinx.android.synthetic.main.activity_add_or_edit_menu.*

class AddOrEditMenu : BaseActivity() {

  private var currentMenuFromIntent: ItemMenuDto? = null

  companion object {
    val CURRENT_MENU = "CURRENT_MENU"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_add_or_edit_menu)
    initialView()

    initialData()
  }

  private fun initialView() {
    getBackActionBar(header, "Add Menu")
  }

  private fun initialData() {
    currentMenuFromIntent =
      intent.getSerializableExtra(CURRENT_MENU) as ItemMenuDto?
    if (currentMenuFromIntent != null && currentMenuFromIntent?.id != 0) {
      editCategoryAction(currentMenuFromIntent)
    } else {
      createCategoryAction()
    }
  }

  private fun editCategoryAction(currentCategory: ItemMenuDto?) {
    getBackActionBar(header, getString(R.string.edit_menu))
    enterMenuTitle.setText(currentCategory?.menuTitle)
    createOrUpdateMenu.setText(getString(R.string.update_menu))
  }

  private fun createCategoryAction() {
    getBackActionBar(header, getString(R.string.create_menu))
    createOrUpdateMenu.setText(getString(R.string.create_menu))
  }
}
