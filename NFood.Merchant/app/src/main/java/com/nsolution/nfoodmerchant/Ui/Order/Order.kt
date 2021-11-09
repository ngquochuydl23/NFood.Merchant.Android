package com.nsolution.nfoodmerchant.Ui.Order

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.nsolution.nfoodmerchant.Adapter.ViewPager.OrderPagerAdapter
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import com.nsolution.nfoodmerchant.Ui.CustomView.BottomSheetView.SetStoreStatusBottomSheet
import com.nsolution.nfoodmerchant.Ui.Employee.Employee
import com.nsolution.nfoodmerchant.Ui.Inbox.Inbox
import com.nsolution.nfoodmerchant.Ui.MenuManagement.MenuManagement
import com.nsolution.nfoodmerchant.Ui.Payment.Payment
import com.nsolution.nfoodmerchant.Ui.Promotions.Promotions
import com.nsolution.nfoodmerchant.Ui.Report.Report
import com.nsolution.nfoodmerchant.Ui.RestaurantProfile.RestaurantProfile
import com.nsolution.nfoodmerchant.Ui.Setting.Setting
import com.nsolution.nfoodmerchant.Ui.StoreSetting.StoreSetting
import kotlinx.android.synthetic.main.activity_order.*

class Order : BaseActivity() {

  lateinit var bottomSheetFragment: SetStoreStatusBottomSheet
  private var containerLayoutInformation : View? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_order)

    bottomSheetFragment = SetStoreStatusBottomSheet()
    containerLayoutInformation = navigationView.getHeaderView(0)

    initialView()
  }

  private fun initialView() {
    setupToolbarLayout()

    tabLayout.setupWithViewPager(viewPager)
    viewPager.adapter = OrderPagerAdapter(supportFragmentManager)
    viewPager.offscreenPageLimit = 3

    setStoreStatusButton.setOnClickListener {
      bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
    }

    navigationView.setNavigationItemSelectedListener {
      when (it.itemId) {
        R.id.navigation_menu -> navigateTo(MenuManagement::class.java)
        R.id.navigation_payment -> navigateTo(Payment::class.java)
        R.id.navigation_inbox -> navigateTo(Inbox::class.java)
        R.id.navigation_promotion -> navigateTo(Promotions::class.java)
        R.id.navigation_employee -> navigateTo(Employee::class.java)
        R.id.navigation_report -> navigateTo(Report::class.java)
        R.id.navigation_academy -> {

        }
        R.id.navigation_store_settings -> navigateTo(StoreSetting::class.java)
        R.id.navigation_app_settings -> navigateTo(Setting::class.java)
        R.id.navigation_sign_out -> {
          signOutAction()
        }
      }
      return@setNavigationItemSelectedListener true
    }

    containerLayoutInformation?.setOnClickListener {
      navigateTo(RestaurantProfile::class.java)
    }
  }

  private fun setupToolbarLayout() {
    val toolbar = findViewById<Toolbar>(R.id.toolbar)
    val title = findViewById<TextView>(R.id.title)
    title.text = getString(R.string.order)
    toolbar.setNavigationIcon(R.drawable.icon_menu_navigation)
    toolbar.setNavigationOnClickListener {
      drawerLayout.open()
    }
  }

  override fun onStop() {
    drawerLayout.closeDrawers()
    super.onStop()
  }

  private fun signOutAction(){
    finish()
  }


}
