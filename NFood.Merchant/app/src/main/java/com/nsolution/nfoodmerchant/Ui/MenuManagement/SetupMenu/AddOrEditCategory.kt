package com.nsolution.nfoodmerchant.Ui.MenuManagement.SetupMenu

import android.os.Bundle
import com.nsolution.nfoodmerchant.Models.AddOrUpdateCategoryDto
import com.nsolution.nfoodmerchant.Models.ItemOverviewCategoryDto
import com.nsolution.nfoodmerchant.Network.IHttpClient
import com.nsolution.nfoodmerchant.Network.ISetupMenu
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_add_or_edit_category.*

class AddOrEditCategory : BaseActivity() {

  private val CURRENT_CATEGORY = "CURRENT_CATEGORY"
  private var currentCategoryFromIntent: ItemOverviewCategoryDto? = null
  private var isCreateCategory : Boolean = false
  lateinit var service: ISetupMenu

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_add_or_edit_category)

    service = IHttpClient.retrofit.create(ISetupMenu::class.java)

    initialView()
    initialData()
  }

  private fun initialView() {

    createOrEditCategory.setOnClickListener {
      val categoryName = enterCategoryName.text.toString()
      if(isCreateCategory){
        createCategory(categoryName)
      } else {
        updateCategory(currentCategoryFromIntent?.categoryId, categoryName)
      }
    }
  }

  private fun initialData() {
    currentCategoryFromIntent = intent.getParcelableExtra(CURRENT_CATEGORY)
    if (currentCategoryFromIntent != null && currentCategoryFromIntent?.categoryId != 0) {
      editCategoryAction(currentCategoryFromIntent)
    } else {
      createCategoryAction()
    }
  }

  private fun editCategoryAction(currentCategory: ItemOverviewCategoryDto?) {
    getBackActionBar(header, getString(R.string.edit_category))
    enterCategoryName.setText(currentCategory?.categoryName)
    createOrEditCategory.setText(getString(R.string.save_change))
    isCreateCategory = false
  }

  private fun createCategoryAction() {
    getBackActionBar(header, getString(R.string.add_new_category))
    createOrEditCategory.setText(getString(R.string.create_category))
    isCreateCategory = true
  }

  private fun createCategory(categoryName : String){
    service.createCategoryAction(tokenAuthenticate, AddOrUpdateCategoryDto(categoryName))
      .observeOn(AndroidSchedulers.mainThread())
      .subscribeOn(Schedulers.io())
      .subscribe({
        finish()
      }, {
        it.printStackTrace()
      })
  }

  private fun updateCategory(categoryId : Int?,categoryName : String?){
    service.updateCategoryAction(tokenAuthenticate, AddOrUpdateCategoryDto(categoryName),categoryId)
      .observeOn(AndroidSchedulers.mainThread())
      .subscribeOn(Schedulers.io())
      .subscribe({
        finish()
      }, {
        it.printStackTrace()
      })
  }
}
