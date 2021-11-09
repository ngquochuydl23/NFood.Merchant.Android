package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nsolution.nfoodmerchant.R

class OverviewCategoryHolder(itemView: View) : BaseHolder(itemView) {
  val categoryName = itemView.findViewById<TextView>(R.id.categoryName)
  val numberItems = itemView.findViewById<TextView>(R.id.numberItems)
  val listMenuFood = itemView.findViewById<RecyclerView>(R.id.listMenuFood)
  val containerLayout = itemView.findViewById<View>(R.id.containerLayout)
  val expandableLayout =
    itemView.findViewById<net.cachapa.expandablelayout.ExpandableLayout>(R.id.expandableLayout)
  val editCategory = itemView.findViewById<View>(R.id.editCategory)
}