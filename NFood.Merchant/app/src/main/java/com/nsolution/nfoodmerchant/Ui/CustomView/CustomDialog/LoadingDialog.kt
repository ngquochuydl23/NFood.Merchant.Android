package com.nsolution.nfoodmerchant.Ui.CustomView.CustomDialog

import android.content.Context
import com.nsolution.nfoodmerchant.R

class LoadingDialog : BaseDialog{

  constructor(context : Context?) : super(context){
    createDialog()
  }

  override fun createDialog() {
    super.createDialog()
    setContentView(R.layout.layout_loading)
    setCanceledOnTouchOutside(false)
  }
}