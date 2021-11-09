package com.nsolution.nfoodmerchant.Ui.Order

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter.OrderFoodAdapter
import com.nsolution.nfoodmerchant.Image.Image
import com.nsolution.nfoodmerchant.Models.InfoDriverSummaryDto
import com.nsolution.nfoodmerchant.Models.ItemOrderFoodDto
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import kotlinx.android.synthetic.main.activity_order_detail.*


class OrderDetail : BaseActivity() {

  private val REQUEST_PHONE_CALL = 1
  private val listPermission = arrayOf(Manifest.permission.CALL_PHONE)
  private var selectPhoneNumber: String? = null
  private lateinit var toolbar: Toolbar

  companion object {
    lateinit var activity: Activity
  }

  init {
    activity = this
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_order_detail)

    toolbar = findViewById(R.id.toolbar)

    setSupportActionBar(toolbar)
    supportActionBar?.setDisplayShowTitleEnabled(false)
    getBackActionBar(header, getString(R.string.order_detail))

    initialView()
    getOrderDetail()


  }

  private fun initialView() {
    listFoodOrderRecyclerView.layoutManager = LinearLayoutManager(this)
  }

  private fun getListFoodOrder(listFoodOrder: ArrayList<ItemOrderFoodDto>?) {
    listFoodOrderRecyclerView.adapter = OrderFoodAdapter(listFoodOrder)
  }

  private fun getDriverInformation(infoDriver: InfoDriverSummaryDto?) {

    Image(this).setImage(driverAvatar, infoDriver?.driverAvatar)
    driverName.text = infoDriver?.driverName
    driverPhoneNumber.text = infoDriver?.driverPhoneNumber

    callDriverButton.setOnClickListener {
      callAction(infoDriver?.driverPhoneNumber)
    }

    trackingButton.setOnClickListener {
      navigateTo(TrackingDriver::class.java)
    }

    cancelButton.setOnClickListener {
      navigateTo(ReasonCancelOrder::class.java)
    }
  }

  private fun getCustomerInformation() {

  }

  private fun getOrderDetail() {
    val infoDriver = InfoDriverSummaryDto().apply {
      driverName = "Ngọc Vân"
      driverAvatar =
        "https://scontent.fdad3-3.fna.fbcdn.net/v/t1.15752-9/93860343_2346686558961766_2416565144390729728_n.jpg?_nc_cat=109&ccb=2&_nc_sid=ae9488&_nc_ohc=DPiNnMn5wAwAX9Mdien&_nc_ht=scontent.fdad3-3.fna&oh=1f3429d5b57467415d5d761dbc449723&oe=6012FEEF"
      driverPhoneNumber = "+84938288768"
      driverId = 1
    }
    val itemFoodOrder = ItemOrderFoodDto().apply {
      foodId = 1
      foodName = "Sữa tươi trân châu đường đen"
      foodPrice = 34000.0
      quanlity = 1
      foodNote = "100% Kem\n50% Đường"
    }

    getListFoodOrder(arrayListOf(itemFoodOrder, itemFoodOrder, itemFoodOrder, itemFoodOrder))
    getDriverInformation(infoDriver)
  }

  private fun callAction(phoneNumber: String?) {
    val intent = Intent(Intent.ACTION_CALL)
    intent.data = Uri.parse("tel:${phoneNumber}")

    val checkSelfPermission =
      ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)

    if (checkSelfPermission != PackageManager.PERMISSION_GRANTED) {
      ActivityCompat.requestPermissions(this, listPermission, REQUEST_PHONE_CALL)
      selectPhoneNumber = phoneNumber
    } else startActivity(intent)
  }

  override fun onRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<out String>,
    grantResults: IntArray
  ) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    if (requestCode == REQUEST_PHONE_CALL && grantResults.size > 0
      && grantResults[0] == PackageManager.PERMISSION_GRANTED
    ) {
      callAction(selectPhoneNumber)
    }
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.menu_order, menu)
    return super.onCreateOptionsMenu(menu)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    if (item.itemId == R.id.printAction) {
      printAction()
    }
    return true
  }

  private fun printAction() {

  }
}
