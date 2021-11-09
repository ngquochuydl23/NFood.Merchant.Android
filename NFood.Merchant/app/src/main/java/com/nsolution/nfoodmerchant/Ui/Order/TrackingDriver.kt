package com.nsolution.nfoodmerchant.Ui.Order


import android.os.Bundle
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapView
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseMapboxActivity
import kotlinx.android.synthetic.main.activity_tracking_driver.*

class TrackingDriver : BaseMapboxActivity() {

  private var mapView: MapView? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_tracking_driver)

    mapView = findViewById(R.id.mapView)
    mapView?.onCreate(savedInstanceState)
    getMapView(mapView)

    initialView()

    val latLng = LatLng().apply {
      latitude = 11.9528
      longitude = 108.4399
    }
    getMap(latLng)
  }

  private fun initialView(){
    getBackActionBar(header,getString(R.string.tracking_driver))
  }

  private fun getMap(latLng: LatLng?){
    mapView?.getMapAsync { mapboxMap ->
      setupMapStyle(mapboxMap)
      moveCamera(latLng)
    }
  }
}
