package com.nsolution.nfoodmerchant.Network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

interface IHttpClient {
  companion object {
    val httpClient: OkHttpClient.Builder
      get() = OkHttpClient.Builder()

    val retrofit: Retrofit
      get() = retrofitBuilder("https://b0096e5d264c.ngrok.io/merchant-api/")

    fun retrofitBuilder(baseUrl: String) : Retrofit {
      return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .client(httpClient.build())
        .build()
    }
  }
}