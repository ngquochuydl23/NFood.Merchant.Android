package com.nsolution.nfoodmerchant.Service

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import com.microsoft.signalr.HubConnection
import com.microsoft.signalr.HubConnectionBuilder
import com.microsoft.signalr.HubConnectionState
import com.nsolution.nfoodmerchant.Models.ReceiveNewOrderDto

class OrderService : Service() {

  private val httpConnectionString = "http://03eb9597dd2a.ngrok.io/trackingServiceHub"
  lateinit var hubConnection: HubConnection
  private val mBinder: IBinder = LocalBinder()

  override fun onBind(intent: Intent): IBinder {
    return mBinder
  }

  override fun onCreate() {
    super.onCreate()

    hubConnection = HubConnectionBuilder
      .create(httpConnectionString)
      .build()
  }

  override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
    return super.onStartCommand(intent, flags, startId)
  }

  fun disconnectFromHub() {
    if (hubConnection.connectionState == HubConnectionState.CONNECTED)
      hubConnection.stop()
  }

  @SuppressLint("CheckResult")
  fun connectToHub() {
    if (hubConnection.connectionState == HubConnectionState.DISCONNECTED) {
      hubConnection.start().subscribe({


        println(hubConnection.connectionState)
      }, {
        it.printStackTrace()
      })
    }
  }

  override fun onDestroy() {
    //disconnectFromHub()
    super.onDestroy()
  }

  class LocalBinder : Binder() {
    val service: OrderService
      get() = OrderService()
  }
}
