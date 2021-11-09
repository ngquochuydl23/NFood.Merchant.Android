package com.nsolution.nfoodmerchant.SharedReferences

import android.content.Context

class SaveTokenSharedPreferences(context: Context?) : BaseSharedPreferences<String?>(context) {

  private val TOKEN_SHARED_PREFERENCES = "TOKEN_SHARED_PREFERENCES"

  override fun setName(): String = TOKEN_SHARED_PREFERENCES

  override fun getData(): String? {
    return sharedPreferences?.getString(TOKEN_SHARED_PREFERENCES, null)
  }

  override fun setData(data: String?) {
    editor.putString(TOKEN_SHARED_PREFERENCES, data).commit()
  }

  override fun deleteData() {
    editor.clear().apply()
  }
}