package com.nsolution.nfoodmerchant.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemEmployeeDto {
  @SerializedName("EmployeeId")
  @Expose
  var employeeId : Int? = null

  @SerializedName("EmployeeName")
  @Expose
  var employeeName : String? = null

  @SerializedName("EmployeeEmail")
  @Expose
  var employeeEmail : String? = null

  @SerializedName("EmployeeType")
  @Expose
  var employeeType : String? = null
}