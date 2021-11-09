package com.nsolution.nfoodmerchant.Adapter.ViewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.nsolution.nfoodmerchant.Ui.Promotions.ComingPromotionFragment
import com.nsolution.nfoodmerchant.Ui.Promotions.CurrentPromotionFragment
import com.nsolution.nfoodmerchant.Ui.Promotions.HistoryPromotionFragment

class PromotionPagerAdapter(fragmentManager: FragmentManager) :
  FragmentStatePagerAdapter(fragmentManager) {

  val comingPromotionFragment = ComingPromotionFragment()
  val currentPromotionFragment = CurrentPromotionFragment()
  val historyPromotionFragment = HistoryPromotionFragment()

  val listFragment =
    arrayListOf(currentPromotionFragment, comingPromotionFragment, historyPromotionFragment)

  val listFragmentTitle = arrayListOf(
    "Current",
    "Coming",
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