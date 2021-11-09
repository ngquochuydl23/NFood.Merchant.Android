package com.nsolution.nfoodmerchant.Adapter.ViewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.nsolution.nfoodmerchant.Ui.Order.CurrentOrderFragment
import com.nsolution.nfoodmerchant.Ui.Order.HistoryOrderFragment
import com.nsolution.nfoodmerchant.Ui.Order.UpcomingOrderFragment

class OrderPagerAdapter(fragmentManager: FragmentManager) :
  FragmentStatePagerAdapter(fragmentManager) {

  val currentOrderFragment = CurrentOrderFragment()
  val upcomingOrderFragment = UpcomingOrderFragment()
  val historyOrderFragment = HistoryOrderFragment()

  val listFragment
          = arrayListOf(currentOrderFragment, upcomingOrderFragment, historyOrderFragment)

  val listFragmentTitle = arrayListOf(
    "Current",
    "Upcoming",
    "History"
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