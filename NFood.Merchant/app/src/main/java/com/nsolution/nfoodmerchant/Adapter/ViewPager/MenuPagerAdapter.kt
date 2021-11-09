package com.nsolution.nfoodmerchant.Adapter.ViewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.nsolution.nfoodmerchant.Ui.MenuManagement.AllFoodFragment
import com.nsolution.nfoodmerchant.Ui.MenuManagement.MenuFoodsFragment
import com.nsolution.nfoodmerchant.Ui.MenuManagement.MenusFragment
import com.nsolution.nfoodmerchant.Ui.MenuManagement.OptionGroupFragment
import com.nsolution.nfoodmerchant.Ui.MenuManagement.SetupMenu.MenuCategoriesFragment

class MenuPagerAdapter(fragmentManager: FragmentManager) :
  FragmentPagerAdapter(fragmentManager) {

  private val OVERVIEW = "Overview"
  private val OPTION_GROUPS = "Option Groups"
  private val MENUS = "Menus"
  private val CATEGORIES = "Categories"
  private val ITEMS = "Items"

  private val overviewFragment = AllFoodFragment()
  private val optionGroupFragment = OptionGroupFragment()
  private val menusFragment = MenusFragment()
  private val menuFoodsFragment = MenuFoodsFragment()
  private val menuCategoriesFragment = MenuCategoriesFragment()

  val listFragment =
    arrayListOf(overviewFragment, menusFragment,menuCategoriesFragment, menuFoodsFragment, optionGroupFragment)
  val listFragmentTitle = arrayListOf(OVERVIEW, MENUS, CATEGORIES, ITEMS, OPTION_GROUPS)

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