package com.nsolution.nfoodmerchant.Ui.RestaurantProfile

import android.app.Activity
import android.content.Intent
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.view.View
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.nsolution.nfoodmerchant.Models.LocationDto
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseMapboxActivity
import kotlinx.android.synthetic.main.activity_select_location_on_map.*

class SelectLocationOnMap : BaseMapboxActivity() {

  private var mapView: MapView? = null
  private val CURRENT_LOCATION = "CURRENT_LOCATION"
  private var currentLocation: LocationDto? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_select_location_on_map)

    initialView()

    mapView = findViewById(R.id.mapView)
    mapView?.onCreate(savedInstanceState)
    getMapView(mapView)

    currentLocation = intent.getSerializableExtra(CURRENT_LOCATION) as LocationDto?
    getMap(currentLocation)
  }

  private fun initialView() {
    getBackActionBar(header, getString(R.string.select_location_on_map))

    confirmLocationButton.setOnClickListener {
      confirmLocationButtonHandle()
    }
  }

  private fun getMap(location: LocationDto?) {
    if (location != null) {
      val latlng = LatLng().apply {
        latitude = location.latitude!!
        longitude = location.longitude!!
      }
      mapView?.getMapAsync { mapboxMap ->
        setupMapStyle(mapboxMap)
        moveCamera(latlng)
        onMoveCamera(mapboxMap)
      }
    }
  }

  private fun onMoveCamera(mapboxMap: MapboxMap) {
    mapboxMap.addOnCameraMoveListener(object : MapboxMap.OnCameraMoveListener {
      override fun onCameraMove() {
        val location = getTargetMapbox()
        currentLocation = location
        updateUI(currentLocation)
      }
    })
  }

  private fun getTargetMapbox(): LocationDto? {
    val mapLatLng = mapboxMap.cameraPosition.target
    val location = LocationDto()

    val shortAddress = getStreet(mapLatLng)
    val longAddress = getAddressDetail(mapLatLng)

    location.apply {
      address = shortAddress
      detailAddress = longAddress
      latitude = mapLatLng.latitude
      longitude = mapLatLng.longitude
    }
    return location
  }

  private fun getStreet(latLng: LatLng?): String? {
    if (latLng != null) {
      val geoLocation = getGeoLocation(latLng)
      val indexStreet = geoLocation?.featureName
      val street = geoLocation?.thoroughfare
      return indexStreet + " " + street
    }
    return null
  }

  private fun getAddressDetail(latLng: LatLng?): String? {
    val geoLocation = getGeoLocation(latLng)
    return geoLocation?.getAddressLine(0)
  }

  private fun getGeoLocation(latLng: LatLng?): Address? {
    val geocoder = Geocoder(this)
    try {
      val resultAddress =
        geocoder.getFromLocation(latLng?.latitude!!, latLng.longitude, 1)
      if (resultAddress != null && resultAddress.isNotEmpty()) {
        return resultAddress.get(0)
      }
    } catch (exception: Exception) {
      street.visibility = View.INVISIBLE
      addressDetail.visibility = View.INVISIBLE
      exception.printStackTrace()
    }
    return null
  }

  private fun confirmLocationButtonHandle() {
    returnIntent(currentLocation)
    finish()
  }

  private fun returnIntent(newLocation: LocationDto?) {
    val returnIntent = Intent()
    returnIntent.putExtra(CURRENT_LOCATION, newLocation)
    setResult(Activity.RESULT_OK, returnIntent)
  }

  private fun updateUI(location : LocationDto?){
    if(location != null){
      val latlng = LatLng(location.latitude!!,location.longitude!!)
      street.text = getStreet(latlng)
      addressDetail.text = getAddressDetail(latlng)
    } else {
      street.visibility = View.GONE
      addressDetail.visibility = View.GONE
    }
  }
}
