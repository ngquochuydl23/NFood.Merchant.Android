package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter

import android.view.ViewGroup
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder.EmployeeHolder
import com.nsolution.nfoodmerchant.Models.ItemEmployeeDto
import com.nsolution.nfoodmerchant.R

class EmployeeAdapter(val listEmployee: ArrayList<ItemEmployeeDto>?) :
  BaseAdapter<EmployeeHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeHolder {
    val view = getView(parent, viewType, R.layout.item_employee)
    return EmployeeHolder(view)
  }

  override fun onBindViewHolder(holder: EmployeeHolder, position: Int) {
    val itemEmployee = listEmployee?.get(position)

    holder.employeeName.text = itemEmployee?.employeeName
    holder.employeeEmail.text = itemEmployee?.employeeEmail
    holder.employeeType.text = itemEmployee?.employeeType
    holder.containerLayout.setOnClickListener {

    }
  }

  override fun getItemCount(): Int {
    return getSizeList(listEmployee)
  }
}