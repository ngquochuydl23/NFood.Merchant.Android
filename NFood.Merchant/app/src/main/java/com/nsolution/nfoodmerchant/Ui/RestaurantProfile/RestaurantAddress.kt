package com.nsolution.nfoodmerchant.Ui.RestaurantProfile

import android.os.Bundle
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapView
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseMapboxActivity
import kotlinx.android.synthetic.main.activity_restaurant_address.*

class RestaurantAddress : BaseMapboxActivity() {

  private var mapView: MapView? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_restaurant_address)

    mapView = findViewById(R.id.mapView)
    mapView?.onCreate(savedInstanceState)
    getMapView(mapView)

    initialView()
    getRestaurantAddress()
  }

  private fun initialView(){
    getBackActionBar(header,getString(R.string.restaurant_address))
  }


  private fun getRestaurantAddress(){
    val latLng = LatLng().apply {
      latitude = 11.9528
      longitude = 108.4399
    }
    getMap(latLng)
  }

  private fun getMap(latLng: LatLng?){
    mapView?.getMapAsync { mapboxMap ->
      setupMapStyle(mapboxMap)
      moveCamera(latLng)
    }
  }
}
