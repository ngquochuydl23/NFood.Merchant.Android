package com.nsolution.nfoodmerchant.Ui.Employee

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter.EmployeeAdapter
import com.nsolution.nfoodmerchant.Models.ItemEmployeeDto
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import kotlinx.android.synthetic.main.activity_employee.*

class Employee : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_employee)

    initialView()
    getListEmployee()
  }

  private fun initialView() {
    getBackActionBar(header, getString(R.string.employee_management))
    listEmployee.layoutManager = LinearLayoutManager(this)

    addAnEmployeeButton.setOnClickListener {
      navigateTo(AddEmployee::class.java)
    }
  }

  private fun getListEmployee(){
    val itemEmployee = ItemEmployeeDto().apply {
      employeeId = 1
      employeeEmail = "yenhoang.hyhy@gmail.com"
      employeeName = "Yến Hoàng"
      employeeType = "Store Manager"
    }

    listEmployee.adapter = EmployeeAdapter(arrayListOf(itemEmployee,itemEmployee,itemEmployee,itemEmployee))
  }
}
