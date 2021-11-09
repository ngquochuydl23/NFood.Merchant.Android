package com.nsolution.nfoodmerchant.Ui.Promotions.CreatePromotion


import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import kotlinx.android.synthetic.main.activity_setup_promotion.*

class SetupPromotion : BaseActivity() {

  private val DISCOUNT_ON_BILL = "DISCOUNT_ON_BILL"
  private val DISCOUNT_ON_FOOD = "DISCOUNT_ON_FOOD"
  private val DISCOUNT_ON_CATEGORY = "DISCOUNT_ON_CATEGORY"

  private val STEP_ONE = 1
  private val STEP_TWO = 2
  private val STEP_THREE = 3

  private var lastSelected: String? = null
  private var currentStep: Int? = null
  private var lastFragment : Fragment? = null

  private val setupPromoStepOneFragment = SetupPromoStepOneFragment()
  private val setupPromoStepTwoFragment = SetupPromoStepTwoFragment()
  private val setupPromoStepThreeFragment = SetupPromoStepThreeFragment()


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_setup_promotion)

    addFragmentToStack(setupPromoStepOneFragment)
    addFragmentToStack(setupPromoStepTwoFragment)
    addFragmentToStack(setupPromoStepThreeFragment)

    initialView()

    navigateToStepOne()
  }

  private fun initialView() {
    nextButton.setOnClickListener {
      switchStepAction()
    }
  }

  private fun navigateToStepOne() {
    currentStep = STEP_ONE
    showFragment(setupPromoStepOneFragment)
    getBackActionBar(header, getString(R.string.create_promotion_step_1))
  }

  private fun selectDiscountOnBill() {
    lastSelected = DISCOUNT_ON_BILL
  }

  private fun selectDiscountOnFood() {
    lastSelected = DISCOUNT_ON_FOOD
  }

  private fun selectDiscountOnCategory() {
    lastSelected = DISCOUNT_ON_CATEGORY
  }

  private fun navigateToStepTwo() {
    showFragment(setupPromoStepTwoFragment)
    getBackActionBar(header, getString(R.string.create_promotion_step_2))

    currentStep = STEP_TWO
  }

  private fun navigateToStepThree() {
    showFragment(setupPromoStepThreeFragment)
    getBackActionBar(header, getString(R.string.create_promotion_step_3))

    currentStep = STEP_THREE
  }

  private fun switchStepAction() {
    when (currentStep) {
      STEP_ONE -> {
        navigateToStepTwo()
      }
      STEP_TWO -> navigateToStepThree()
    }
  }

  override fun getBackActionBar(toolbarLayout: View, titleActionBar: String?) {
    val toolbar = toolbarLayout.findViewById<Toolbar>(R.id.toolbar)
    val titleToolbar = toolbarLayout.findViewById<TextView>(R.id.title)

    toolbar.setNavigationIcon(R.drawable.icon_back)
    toolbar.setNavigationOnClickListener {
      backAction()
    }

    titleToolbar.text = titleActionBar
  }

  override fun onBackPressed() {
    backAction()
  }

  private fun backAction() {
    when (currentStep) {
      STEP_ONE -> finish()
      STEP_TWO -> navigateToStepOne()
      STEP_THREE -> navigateToStepTwo()
    }
  }

  private fun addFragmentToStack(fragment: Fragment) {
    supportFragmentManager.commit {
      add(R.id.fragmentContainer, fragment)
      hide(fragment)
    }
  }

  private fun showFragment(fragment: Fragment){
    supportFragmentManager.commit {
      show(fragment)
      lastFragment?.let {
        hide(it)
      }
    }
    lastFragment = fragment
  }
}
