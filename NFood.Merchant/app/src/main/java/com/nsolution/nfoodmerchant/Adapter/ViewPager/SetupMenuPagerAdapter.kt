package com.nsolution.nfoodmerchant.Adapter.ViewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.nsolution.nfoodmerchant.Ui.MenuManagement.SetupMenu.SetupAllFoodFragment
import com.nsolution.nfoodmerchant.Ui.MenuManagement.OptionGroup.SetupOptionGroupFragment

class SetupMenuPagerAdapter(fragmentManager: FragmentManager) :
  FragmentStatePagerAdapter(fragmentManager) {

  private val ALL_FOOD = "All Food"
  private val OPTION_GROUPS = "Option Groups"
  private val setupAllFoodFragment = SetupAllFoodFragment()
  private val optionGroupFragment = SetupOptionGroupFragment()

  private val listFragment = arrayListOf(setupAllFoodFragment, optionGroupFragment)
  private val listFragmentTitle = arrayListOf(ALL_FOOD, OPTION_GROUPS)

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