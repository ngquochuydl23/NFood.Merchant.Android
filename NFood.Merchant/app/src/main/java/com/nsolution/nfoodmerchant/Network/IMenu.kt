package com.nsolution.nfoodmerchant.Network

import com.nsolution.nfoodmerchant.Models.ItemOverviewCategoryDto
import com.nsolution.nfoodmerchant.Models.ResultAction
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Header

interface IMenu {
  @GET("Menu/AllFood")
  fun getAll(
    @Header("Authorization") token: String?
  ): Observable<ResultAction<ArrayList<ItemOverviewCategoryDto>>>
}