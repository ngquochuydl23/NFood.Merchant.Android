package com.nsolution.nfoodmerchant.Ui.RestaurantProfile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.mapbox.api.staticmap.v1.MapboxStaticMap
import com.mapbox.api.staticmap.v1.StaticMapCriteria
import com.mapbox.geojson.Point
import com.nsolution.nfoodmerchant.Image.Image
import com.nsolution.nfoodmerchant.Models.LocationDto
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseActivity
import kotlinx.android.synthetic.main.activity_edit_restaurant_profile.*


class EditRestaurantProfile : BaseActivity() {

  private val CURRENT_LOCATION = "CURRENT_LOCATION"
  private val SELECT_LOCATION_ON_MAP_RESULT = 1

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_edit_restaurant_profile)
    initialView()

    val location = LocationDto().apply {
      address = "242 Bùi Thị Xuân"
      detailAddress = "242 Bùi Thị Xuân, Phường 2, Thành phố Đà Lạt"
      latitude = 11.9528
      longitude = 108.4399
    }

    getLocation(location)

    editAddress.setOnClickListener {
      val intent = Intent(this, SelectLocationOnMap::class.java)
      intent.putExtra(CURRENT_LOCATION, location)
      startActivityForResult(intent, SELECT_LOCATION_ON_MAP_RESULT)
    }
  }

  private fun initialView() {
    getBackActionBar(header, getString(R.string.edit_restaurant_information))
  }

  private fun getMapStatic(location: LocationDto?) {
    val mapBoxAccessToken = getString(R.string.mapbox_access_token)

    val staticImage = MapboxStaticMap.builder()
      .accessToken(mapBoxAccessToken)
      .styleId(StaticMapCriteria.STREET_STYLE)
      .cameraPoint(Point.fromLngLat(location?.longitude!!, location.latitude!!))
      .cameraZoom(14.0)
      .width(100)
      .height(100)
      .retina(true)
      .build()

    val imageMapUrl = staticImage.url().toString()
    Image(this).setImage(mapStaticView, imageMapUrl)
  }

  private fun getLocation(location: LocationDto?){
    getMapStatic(location)
    detailAddress.text = location?.detailAddress
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (requestCode == SELECT_LOCATION_ON_MAP_RESULT && resultCode == Activity.RESULT_OK) {
      val newLocation = data?.getSerializableExtra(CURRENT_LOCATION) as LocationDto
      getLocation(newLocation)
    }
  }
}
