package com.nsolution.nfoodmerchant.Ui.MenuManagement.SetupMenu

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.nsolution.nfoodmerchant.Image.CropImage
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import com.yalantis.ucrop.UCrop
import kotlinx.android.synthetic.main.activity_proof_menu_change.*

class ProofMenuChange : BaseActivity() {

  private val PICK_IMAGE_ACTION = 1
  private var imageUri: Uri? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_proof_menu_change)
    initialView()
  }

  private fun initialView() {
    getBackActionBar(header, getString(R.string.proof_menu_change))
    menuImage.setOnClickListener {
      selectImageFromDevice()
    }
    uploadPhotoAndAddItemButton.setOnClickListener {
      uploadPhotoAndAddItem()
    }
  }

  private fun selectImageFromDevice() {
    val intent = Intent()
    intent.type = "image/*"
    intent.action = Intent.ACTION_GET_CONTENT
    startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_ACTION)
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (resultCode == Activity.RESULT_OK) {
      when (requestCode) {
        PICK_IMAGE_ACTION -> CropImage(this).cropImage(data, 1.5F, 2F)
        UCrop.REQUEST_CROP -> {
          imageUri = UCrop.getOutput(data!!)
          applyImageWithUri(imageUri)
        }
      }
    }
  }

  private fun uploadPhotoAndAddItem(){
    finishReviewActivity()
    finishAddOrEditFood()
    finish()



    updateMenuToServer()
  }

  private fun finishReviewActivity(){
    Review.activity.finish()
  }

  private fun finishAddOrEditFood(){
    AddOrEditFood.activity.finish()
  }

  private fun applyImageWithUri(imageUri: Uri?) {
    menuImage.setImageURI(imageUri)
  }

  private fun updateMenuToServer(){

  }
}
