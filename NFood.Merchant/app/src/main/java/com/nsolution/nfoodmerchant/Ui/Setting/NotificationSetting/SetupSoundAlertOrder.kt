package com.nsolution.nfoodmerchant.Ui.Setting.NotificationSetting


import android.media.MediaPlayer
import android.os.Bundle
import com.nsolution.nfoodmerchant.Models.SoundOrderAlert
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.SharedReferences.SoundOrderAlertSharedPreferences
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import kotlinx.android.synthetic.main.activity_setup_sound_alert_order.*

class SetupSoundAlertOrder : BaseActivity() {

  private var mediaPlayer: MediaPlayer? = null

  private val DEFAULT_SOUND = 1
  private val SOUND_ONE = 2
  private val SOUND_TWO = 3
  private val SOUND_THREE = 3
  private var selectSound : SoundOrderAlert? = null


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_setup_sound_alert_order)

    initialView()

    val currentSound = getCurrentSoundFromDevice()

    if (currentSound != null) {
      when (currentSound.id) {
        DEFAULT_SOUND -> {
          defaultSoundRadioButton.isChecked = true
          selectSound = SoundOrderAlert(DEFAULT_SOUND,R.raw.sound_default)
        }
        SOUND_ONE -> {
          sound1RadioButton.isChecked = true
          selectSound = SoundOrderAlert(SOUND_ONE,R.raw.sound_1)
        }
        SOUND_TWO -> {
          sound2RadioButton.isChecked = true
          selectSound = SoundOrderAlert(SOUND_TWO,R.raw.sound_2)
        }
        SOUND_THREE -> {
          sound3RadioButton.isChecked = true
          selectSound = SoundOrderAlert(SOUND_THREE,R.raw.sound_3)
        }
      }
    }
  }

  private fun initialView() {
    getBackActionBar(header, getString(R.string.new_order_alert))

    defaultSoundRadioButton.setOnClickListener {
      playSound(R.raw.sound_default)
      selectSound = SoundOrderAlert(DEFAULT_SOUND,R.raw.sound_default)
    }

    sound1RadioButton.setOnClickListener {
      playSound(R.raw.sound_1)
      selectSound = SoundOrderAlert(SOUND_ONE,R.raw.sound_1)
    }

    sound2RadioButton.setOnClickListener {
      playSound(R.raw.sound_2)
      selectSound = SoundOrderAlert(SOUND_TWO,R.raw.sound_2)
    }

    sound3RadioButton.setOnClickListener {
      playSound(R.raw.sound_3)
      selectSound = SoundOrderAlert(SOUND_THREE,R.raw.sound_3)
    }

    selectSoundButton.setOnClickListener {
      if(selectSound != null) {
        saveCurrentSoundToDevice(selectSound)
        finish()
      }
    }
  }

  private fun playSound(sound: Int) {
    stopCurrentSound()
    createSound(sound)
    startSound()
  }

  private fun createSound(sound: Int) {
    mediaPlayer = MediaPlayer.create(this, sound)
  }

  private fun getCurrentSoundFromDevice(): SoundOrderAlert? {
    return SoundOrderAlertSharedPreferences(this).getData()
  }

  private fun saveCurrentSoundToDevice(currentSound: SoundOrderAlert?) {
    SoundOrderAlertSharedPreferences(this).setData(currentSound)
  }

  private fun stopCurrentSound() {
    mediaPlayer?.stop()
    mediaPlayer?.reset()
  }

  private fun startSound() {
    mediaPlayer?.start()
  }

  override fun onBackPressed() {
    super.onBackPressed()
    mediaPlayer?.stop()
  }

  override fun onStop() {
    super.onStop()
    mediaPlayer?.stop()
  }

  override fun onDestroy() {
    super.onDestroy()
    mediaPlayer?.stop()
  }

  override fun getNavigationClick() {
    super.getNavigationClick()
    mediaPlayer?.stop()
  }
}
