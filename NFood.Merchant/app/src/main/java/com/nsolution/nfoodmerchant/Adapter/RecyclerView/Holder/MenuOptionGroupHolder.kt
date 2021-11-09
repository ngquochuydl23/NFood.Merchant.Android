package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nsolution.nfoodmerchant.R
import net.cachapa.expandablelayout.ExpandableLayout

class MenuOptionGroupHolder(itemView : View) : BaseHolder(itemView){
  val optionGroupName = itemView.findViewById<TextView>(R.id.optionGroupName)
  val containerLayout = itemView.findViewById<View>(R.id.containerLayout)
  val expandableLayout = itemView.findViewById<ExpandableLayout>(R.id.expandableLayout)
  val listOption = itemView.findViewById<RecyclerView>(R.id.listOption)
}