package com.nsolution.nfoodmerchant.Image

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat
import com.nsolution.nfoodmerchant.R
import com.yalantis.ucrop.UCrop

class CropImage(val context: Context) {

  private val ASPECT_RATIO_X = 1F
  private val ASPECT_RATIO_Y = 1F
  private val bitmapMaxWidth = 1000
  private val bitmapMaxHeight = 1000
  private val IMAGE_COMPRESSION = 80

  fun cropImage(data: Intent?, aspectRatioX: Float, aspectRatioY: Float) {
    val sourceUri = data?.data
    if (sourceUri != null) {

      val newFile = FileImage.getFile(context.cacheDir, context.contentResolver, sourceUri)
      val destinationUri = Uri.fromFile(newFile)
      val options = setupOptionUCrop(aspectRatioX, aspectRatioY)

      UCrop.of(sourceUri, destinationUri)
        .withOptions(options)
        .start(context as Activity)
    }
  }

  fun setupOptionUCrop(aspectRatioX: Float, aspectRatioY: Float): UCrop.Options {
    val option = UCrop.Options()
    val whiteColor = ContextCompat.getColor(context, R.color.white)

    option.apply {
      setCompressionQuality(IMAGE_COMPRESSION)
      setToolbarColor(whiteColor)
      setHideBottomControls(true)
      setToolbarTitle("Crop Image")
      setStatusBarColor(whiteColor)
      withMaxResultSize(bitmapMaxWidth, bitmapMaxHeight)
      withAspectRatio(aspectRatioX, aspectRatioY)
    }
    return option
  }
}