package com.nsolution.nfoodmerchant.Ui.MenuManagement.SetupMenu

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.nsolution.nfoodmerchant.Image.Image
import com.nsolution.nfoodmerchant.Models.AddOrUpdateFoodDto
import com.nsolution.nfoodmerchant.Models.ItemMenuFoodDto
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import com.nsolution.nfoodmerchant.Ui.Currency.FormatCurrency
import kotlinx.android.synthetic.main.activity_review.*

class Review : BaseActivity() {

  private var reviewFood: ItemMenuFoodDto? = null
  private val IS_EDIT = "IS_EDIT"
  private val REVIEW_FOOD = "REVIEW_FOOD"

  companion object {
    lateinit var activity: Activity
  }

  init {
    activity = this
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_review)
    initialView()

    val currentFood = intent.getSerializableExtra(REVIEW_FOOD) as AddOrUpdateFoodDto?
    val isEditFood = intent.getSerializableExtra(IS_EDIT)

    applyDataFoodToView(currentFood)
  }

  private fun initialView() {
    getBackActionBar(header, getString(R.string.review_food))
    nextButton.setOnClickListener {
      navigateTo(ProofMenuChange::class.java)
    }
  }

  private fun reviewFood(itemFood: AddOrUpdateFoodDto) {
    applyDataFoodToView(itemFood)
  }

  private fun applyDataFoodToView(itemFood: AddOrUpdateFoodDto?) {
    val categoryName = findViewById<TextView>(R.id.categoryName)
    val foodImage = findViewById<ImageView>(R.id.foodImage)
    val foodName = findViewById<TextView>(R.id.foodName)
    val foodDiscription = findViewById<TextView>(R.id.foodDiscription)
    val foodPrice = findViewById<TextView>(R.id.foodPrice)

    foodName.text = itemFood?.foodName
    foodPrice.text = FormatCurrency.FormatCurrencyVietNam(itemFood?.foodPrice)
    foodDiscription.text = itemFood?.foodDiscription
    categoryName.text = itemFood?.category
    Image(this).setImage(foodImage, itemFood?.foodImage)
  }
}
