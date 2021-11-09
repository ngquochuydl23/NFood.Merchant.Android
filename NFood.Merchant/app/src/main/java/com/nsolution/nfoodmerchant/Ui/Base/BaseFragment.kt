package com.nsolution.nfoodmerchant.Ui.Base

import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.SharedReferences.SaveTokenSharedPreferences

abstract class BaseFragment() : Fragment() {

  fun navigateTo(activity: Class<*>){
    val intent = Intent(context,activity)
    startActivity(intent)
  }

  val supportActionBar: ActionBar?
    get() = (activity as AppCompatActivity).supportActionBar

  open fun getActionBarWithNoNavigation(toolbarLayout: View, titleActionBar: String) {
    val toolbar = toolbarLayout.findViewById<Toolbar>(R.id.toolbar)
    val title = toolbarLayout.findViewById<TextView>(R.id.title)
    title.text = titleActionBar

  }

  fun setSupportActionBar(toolbarLayout: View){
    val contextActivity = (activity as AppCompatActivity)

    val toolbar = toolbarLayout.findViewById<Toolbar>(R.id.toolbar)
    contextActivity.setSupportActionBar(toolbar)

  }

  fun setDisplayShowTitleEnabled(boolean: Boolean){
    supportActionBar?.setDisplayShowTitleEnabled(boolean)
  }

  val tokenAuthenticate: String
  get() = "Bearer ${SaveTokenSharedPreferences(context).getData()}"

}