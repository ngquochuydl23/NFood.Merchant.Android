package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.TextView
import com.nsolution.nfoodmerchant.R

class EmployeeHolder(itemView : View) : BaseHolder(itemView) {
  val containerLayout = itemView.findViewById<View>(R.id.containerLayout)
  val employeeName = itemView.findViewById<TextView>(R.id.employeeName)
  val employeeEmail = itemView.findViewById<TextView>(R.id.employeeEmail)
  val employeeType = itemView.findViewById<TextView>(R.id.employeeType)
}