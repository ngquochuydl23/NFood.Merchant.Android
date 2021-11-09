package com.nsolution.nfoodmerchant.Adapter.ViewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.nsolution.nfoodmerchant.Ui.Report.ReportFoodFragment
import com.nsolution.nfoodmerchant.Ui.Report.ReportRestaurantFragment

class ReportPagerAdapter(fragmentManager: FragmentManager) :
  FragmentStatePagerAdapter(fragmentManager) {

  val reportRestaurant = ReportRestaurantFragment()
  val reportFood = ReportFoodFragment()

  val listFragment = arrayListOf(reportRestaurant, reportFood)
  val listFragmentTitle = arrayListOf(
    "Restaurant",
    "Food"
  )

  override fun getCount(): Int {
    return listFragment.size
  }

  override fun getItem(position: Int): Fragment {
    return listFragment.get(position)
  }

  override fun getPageTitle(position: Int): CharSequence? {
    return listFragmentTitle.get(position)
  }
}