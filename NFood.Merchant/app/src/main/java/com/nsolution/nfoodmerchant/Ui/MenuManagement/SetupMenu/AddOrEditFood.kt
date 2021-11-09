package com.nsolution.nfoodmerchant.Ui.MenuManagement.SetupMenu

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.nsolution.nfoodmerchant.Image.CropImage
import com.nsolution.nfoodmerchant.Image.Image
import com.nsolution.nfoodmerchant.Models.AddOrUpdateFoodDto
import com.nsolution.nfoodmerchant.Models.ItemMenuFoodDto
import com.nsolution.nfoodmerchant.Models.ItemSelectCategoryDto
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import com.nsolution.nfoodmerchant.Ui.CustomView.BottomSheetView.SelectCategoryBottomSheet
import com.yalantis.ucrop.UCrop
import kotlinx.android.synthetic.main.activity_add_or_edit_food.*
import kotlinx.android.synthetic.main.activity_setup_menu.header

class AddOrEditFood : BaseActivity(), SelectCategoryBottomSheet.BottomSheetListener {

  private val CURRENT_FOOD = "CURRENT_FOOD"
  private val IS_EDIT = "IS_EDIT"
  private val REVIEW_FOOD = "REVIEW_FOOD"
  private val PICK_IMAGE_ACTION = 1

  private var currentFoodFromIntent: ItemMenuFoodDto? = null
  lateinit var bottomSheetFragment: SelectCategoryBottomSheet
  private var imageUri: Uri? = null
  private var isEditFood: Boolean = false

  private var currentCategoryId: Int? = null
  private var currentFoodId: Int? = null
  private var currentFoodImage : String? = null
  private var currentFoodName : String? = null
  private var currentFoodDiscription : String? = null
  private var currentFoodPrice : Double? = null
  private var currentCategoryName : String? = null

  companion object {
    lateinit var activity: Activity
  }

  init {
    activity = this
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_add_or_edit_food)
    bottomSheetFragment = SelectCategoryBottomSheet()

    initialView()
    initialData()
  }

  private fun initialView() {
    selectImageLayout.setOnClickListener {
      selectImageFromDevice()
    }
    selectCategory.setOnClickListener {
      bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
    }
    reviewFoodButton.setOnClickListener {
      reviewFoodAction()
    }
  }

  private fun initialData() {
    currentFoodFromIntent = intent.getParcelableExtra<ItemMenuFoodDto?>(CURRENT_FOOD)
    if (currentFoodFromIntent != null && currentFoodFromIntent?.foodId != 0) {
      editFoodAction(currentFoodFromIntent)
    } else addFoodAction()
    getSelectCategory()
  }

  private fun editFoodAction(currentFood: ItemMenuFoodDto?) {
    getBackActionBar(header, getString(R.string.edit_food))
    isEditFood = true
    currentFoodId = currentFood?.foodId
    currentCategoryId = currentFood?.categoryId
    currentFoodImage = currentFood?.foodImage
    currentFoodName = currentFood?.foodName
    currentFoodDiscription = currentFood?.foodDiscription
    currentFoodPrice = currentFood?.foodPrice
    //currentCategoryName = currentFood?.category

    enterFoodName.setText(currentFoodName)
    enterFoodDiscription.setText(currentFoodDiscription)
    enterFoodPrice.setText(currentFoodPrice.toString())
    //selectCategory.setText(currentFood?.category)
    Image(this).setImage(foodImage, currentFoodImage)
  }

  private fun addFoodAction() {
    getBackActionBar(header, getString(R.string.add_new_food))
    isEditFood = true
  }

  override fun onSelectItemCategory(selectedCategory: ItemSelectCategoryDto?) {
    assignedItemselectCategory(selectedCategory)
  }

  private fun getSelectCategory() {
    val selectCategoryList = arrayListOf<ItemSelectCategoryDto>()
    val itemSelectCategory1 = ItemSelectCategoryDto().apply {
      categoryId = 1
      categoryName = "Cà phê"
    }
    val itemSelectCategory2 = ItemSelectCategoryDto().apply {
      categoryId = 2
      categoryName = "Trà sữa"
    }
    val itemSelectCategory3 = ItemSelectCategoryDto().apply {
      categoryId = 3
      categoryName = "Sinh tố"
    }
    selectCategoryList.add(itemSelectCategory1)
    selectCategoryList.add(itemSelectCategory2)
    selectCategoryList.add(itemSelectCategory3)

    bottomSheetFragment.setListCategory(selectCategoryList)
  }

  private fun assignedItemselectCategory(selectedCategory: ItemSelectCategoryDto?) {
    currentCategoryName = selectedCategory?.categoryName
    currentCategoryId = selectedCategory?.categoryId
    selectCategory.setText(currentCategoryName)
  }

  private fun selectImageFromDevice() {
    val intent = Intent()
    intent.type = "image/*"
    intent.action = Intent.ACTION_GET_CONTENT
    startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_ACTION)
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (resultCode == Activity.RESULT_OK) {
      when (requestCode) {
        PICK_IMAGE_ACTION -> CropImage(this).cropImage(data, 1F, 1F)
        UCrop.REQUEST_CROP -> {
          imageUri = UCrop.getOutput(data!!)
          applyImageWithUri(imageUri)
        }
      }
    }
  }

  private fun applyImageWithUri(imageUri: Uri?) {
    foodImage.setImageURI(imageUri)
  }

  private fun reviewFoodAction() {
    currentFoodName = enterFoodName.text.toString()
    currentFoodDiscription = enterFoodDiscription.text.toString()
    currentFoodPrice  = enterFoodPrice.text.toString().toDoubleOrNull()

    val addOrEditFood = AddOrUpdateFoodDto(
      currentFoodId,
      currentFoodName,
      currentFoodImage,
      currentFoodDiscription,
      currentFoodPrice,
      currentCategoryId,
      currentCategoryName
    )

    val intent = Intent(this, Review::class.java)
    intent.apply {
      putExtra(IS_EDIT, isEditFood)
      putExtra(REVIEW_FOOD, addOrEditFood)
    }
    startActivity(intent)
  }
}
