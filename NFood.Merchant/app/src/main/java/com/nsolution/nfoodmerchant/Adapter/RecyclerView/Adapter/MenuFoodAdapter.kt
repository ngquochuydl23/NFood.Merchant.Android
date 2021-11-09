package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter

import android.content.DialogInterface
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder.MenuFoodHolder
import com.nsolution.nfoodmerchant.Models.ItemMenuFoodDto
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Currency.FormatCurrency
import com.nsolution.nfoodmerchant.Ui.CustomView.BottomSheetView.SoldOutFoodBottomSheet
import com.nsolution.nfoodmerchant.Ui.MenuManagement.SetupMenu.AddOrEditFood
import java.io.Serializable

open class MenuFoodAdapter(val listFood: ArrayList<ItemMenuFoodDto>?, val isAllowEdit: Boolean) :
  BaseAdapter<MenuFoodHolder>(){

  private val CURRENT_FOOD = "CURRENT_FOOD"

  lateinit var bottomSheetFragment: SoldOutFoodBottomSheet
  lateinit var fragmentManager: FragmentManager
  private val OUT_OF_STOCK_TODAY = "Out of stock today"
  private val OUT_OF_STOCK_INDEFINITELY = "Out of stock indefinitely"

  private var currentFoodView: MenuFoodHolder? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuFoodHolder {

    val view = getView(parent, viewType, R.layout.item_menu_food)
    val viewEdit = getView(parent, viewType, R.layout.item_edit_menu_food)

    fragmentManager = (context as FragmentActivity).supportFragmentManager
    bottomSheetFragment = SoldOutFoodBottomSheet()

    if (isAllowEdit)
      return MenuFoodHolder(viewEdit)
    return MenuFoodHolder(view)
  }

  override fun onBindViewHolder(holder: MenuFoodHolder, position: Int) {
    val itemFood = listFood?.get(position)

    holder.foodName.text = itemFood?.foodName
    holder.foodPrice.text = FormatCurrency.FormatCurrencyVietNam(itemFood?.foodPrice)
    setImage(holder.foodImage, itemFood?.foodImage)

    if (!isAllowEdit) {
      holder.foodStatus.text = itemFood?.foodManagement?.typeSoldOut
      holder.switchOutOfStock.isChecked = itemFood?.foodManagement?.isSoldOut as Boolean
      holder.switchOutOfStock.setOnCheckedChangeListener { buttonView, isChecked ->

      }
    } else {
      holder.editFoodButton.setOnClickListener {
        if (itemFood != null) {
          editFoodAction(itemFood)
        }
      }
    }
  }

  override fun getItemCount(): Int {
    return getSizeList(listFood)
  }

  private fun editFoodAction(currentFood: ItemMenuFoodDto) {
    val intent = Intent(context, AddOrEditFood::class.java)
    intent.putExtra(CURRENT_FOOD, currentFood)
    context.startActivity(intent)
  }

  fun onSoldOutForToday() {
    currentFoodView?.foodStatus?.text = OUT_OF_STOCK_TODAY
    currentFoodView?.foodStatus?.visibility = View.VISIBLE
  }

  fun onSoldOutForIndefinitely() {
    currentFoodView?.foodStatus?.text = OUT_OF_STOCK_INDEFINITELY
    currentFoodView?.foodStatus?.visibility = View.VISIBLE
  }
}