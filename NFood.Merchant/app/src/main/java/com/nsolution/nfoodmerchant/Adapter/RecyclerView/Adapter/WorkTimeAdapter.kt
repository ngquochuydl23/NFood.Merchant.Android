package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter

import android.view.ViewGroup
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder.WorkTimeHolder
import com.nsolution.nfoodmerchant.Models.ItemWorkTimeDto
import com.nsolution.nfoodmerchant.R

open class WorkTimeAdapter(val listWorkTime : ArrayList<ItemWorkTimeDto>?) : BaseAdapter<WorkTimeHolder>(){

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkTimeHolder {
    val view = getView(parent,viewType, R.layout.item_work_time)
    return WorkTimeHolder(view)
  }

  override fun onBindViewHolder(holder: WorkTimeHolder, position: Int) {
    val itemWorkTime = listWorkTime?.get(position)

    holder.dayOfWeek.text = itemWorkTime?.dayOfWeek
    holder.workTime.text = itemWorkTime?.workTime
    holder.editWorkTime.setOnClickListener {
      editWorkTime()
    }
  }

  override fun getItemCount(): Int {
    return getSizeList(listWorkTime)
  }

  open fun editWorkTime(){

  }
}