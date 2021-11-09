package com.nsolution.nfoodmerchant.Network

import com.nsolution.nfoodmerchant.Models.AddOrUpdateCategoryDto
import com.nsolution.nfoodmerchant.Models.ItemOverviewCategoryDto
import com.nsolution.nfoodmerchant.Models.ResultAction
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ISetupMenu {
  @POST("SetupMenu/CreateCategory")
  fun createCategoryAction(
    @Header("Authorization") token: String?,
    @Body createOrUpdateCategory : AddOrUpdateCategoryDto
  ): Observable<ResultAction<ItemOverviewCategoryDto>>

  @POST("SetupMenu/UpdateCategory/{categoryId}")
  fun updateCategoryAction(
    @Header("Authorization") token: String?,
    @Body createOrUpdateCategory : AddOrUpdateCategoryDto,
    @Path("categoryId") categoryId : Int?
  ): Observable<ResultAction<ItemOverviewCategoryDto>>
}