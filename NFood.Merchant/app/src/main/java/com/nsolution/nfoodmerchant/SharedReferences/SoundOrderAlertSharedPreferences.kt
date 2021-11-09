package com.nsolution.nfoodmerchant.SharedReferences

import android.content.Context
import com.google.gson.Gson
import com.nsolution.nfoodmerchant.Models.SoundOrderAlert

class SoundOrderAlertSharedPreferences(context: Context?) : BaseSharedPreferences<SoundOrderAlert?>(context) {

  private val SOUND_NAME = "SOUND_NAME"

  override fun setName(): String = SOUND_NAME

  override fun getData(): SoundOrderAlert? {
    val dataJson = sharedPreferences?.getString(SOUND_NAME,null)
    return Gson().fromJson(dataJson, SoundOrderAlert::class.java)
  }

  override fun setData(data: SoundOrderAlert?) {
    if(data != null){
      val dataJson = Gson().toJson(data)
      editor.putString(SOUND_NAME, dataJson).commit()
    }
  }

  override fun deleteData() {
    editor.clear().apply()
  }
}